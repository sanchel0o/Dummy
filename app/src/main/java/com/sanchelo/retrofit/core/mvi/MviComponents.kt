package com.sanchelo.retrofit.core.mvi

import kotlinx.coroutines.flow.Flow

fun interface MviBoot
<Effect : MviEffect> : () -> Flow<Effect> {
    override fun invoke(): Flow<Effect>
}

fun interface MviActor
<Action : MviAction, Effect : MviEffect, State : MviState> : suspend (Action, State) -> Flow<Effect> {
    override suspend fun invoke(action: Action, state: State): Flow<Effect>
}

fun interface MviEventProducer
<Effect : MviEffect, Event : MviEvent> : suspend (Effect) -> Event? {
    override suspend fun invoke(effect: Effect): Event?
}

fun interface MviStateProducer
<Effect : MviEffect, State : MviState> : suspend (Effect, State) -> State {
    override suspend fun invoke(effect: Effect, previousState: State): State
}