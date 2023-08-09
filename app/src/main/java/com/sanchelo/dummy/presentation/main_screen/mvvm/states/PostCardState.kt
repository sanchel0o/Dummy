package com.sanchelo.dummy.presentation.main_screen.mvvm.states

import com.sanchelo.dummy.domain.model.PostData

data class PostCardState(
    val isLoading: Boolean = false,
    val postData: PostData? = null,
    val isLikeChecked: Boolean = false,
)
