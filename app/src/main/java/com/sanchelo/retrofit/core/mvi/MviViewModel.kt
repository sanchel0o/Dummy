package com.sanchelo.retrofit.core.mvi

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import androidx.compose.runtime.State as ComposeState

abstract class MviViewModel
<Action : MviAction, Effect : MviEffect, Event : MviEvent, State : MviState>(
    private val defaultState: State,
    private val actor: MviActor<Action, Effect, State>,
    private val boot: MviBoot<Effect>,
    private val eventProducer: MviEventProducer<Effect, Event>,
    private val stateProducer: MviStateProducer<Effect, State>,
    private val tag: String,
    private val logEnable: Boolean = true,
    private val logger: MviLogger = MviLoggerDefault,
) : ViewModel() {

    private var stateFlow: StateFlow<State>? = null //

    private val currentState: State
        get() = stateFlow?.value ?: defaultState

    private val eventFlow: MutableSharedFlow<Event> = MutableSharedFlow(
        replay = EVENTS_REPLAY_COUNT,
        extraBufferCapacity = EVENTS_BUFFER_SIZE,
        onBufferOverflow = BufferOverflow.SUSPEND
    )

    private val actionsFlow: MutableSharedFlow<Action> = MutableSharedFlow(
        replay = ACTIONS_REPLAY_COUNT,
        extraBufferCapacity = ACTIONS_BUFFER_SIZE,
        onBufferOverflow = BufferOverflow.SUSPEND
    )

    private fun log(message: String) {
        if (logEnable) {
            logger.log(tag, message)
        }
    }

    @OptIn(FlowPreview::class)
    private fun mergeBootAndActionEffect(): Flow<Effect?> = merge(
        boot()
            .onEach { log("BOOT EFFECT -> $it") },
        actionsFlow
            .onEach { log("ACTION EFFECT -> $it") }
            .flatMapMerge { actor(it, currentState) },
    )

    private fun Flow<Effect>.produceEvent(): Flow<Effect> = this
        .map { eventProducer(it) to it }
        .onEach { (event, _) -> event?.let { log("EVENT -> $it") } }
        .onEach { (event, _) -> event?.let { eventFlow.emit(it) } }
        .map { (_, effect) -> effect }

    private fun Flow<Effect>.produceState(): Flow<State> = this
        .map { stateProducer(it, currentState) }
        .onEach { log("NEW STATE -> $it") }

    private fun Flow<State>.stateIn(): StateFlow<State> = this
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = defaultState
        )

    private fun getState(): StateFlow<State> = stateFlow ?: mergeBootAndActionEffect()
        .filterNotNull()
        .produceEvent()
        .distinctUntilChanged()
        .produceState()
        .stateIn()
        .also { stateFlow = it }

    fun acceptAction(action: Action) {
        viewModelScope.launch { actionsFlow.emit(action) }
    }

    @Composable
    fun collectAsStateWithLifecycle(): ComposeState<State> = getState()
        .collectAsStateWithLifecycle()

    @Composable
    fun EventEffect(
        onEvent: (Event) -> Unit = {}
    ) {
        LaunchedEffect(Unit) {
            eventFlow.collectLatest(onEvent)
        }
    }
}

private const val ACTIONS_REPLAY_COUNT = 0
private const val ACTIONS_BUFFER_SIZE = 10
private const val EVENTS_REPLAY_COUNT = 0
private const val EVENTS_BUFFER_SIZE = 10
