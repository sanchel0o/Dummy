package com.sanchelo.dummy.presentation.main_screen.events

sealed class MainScreenEvents {
    data class CardClick(val id: Int): MainScreenEvents()
    data class AddToCart(val id: Int): MainScreenEvents()
    data class AddToFavorites(val id: Int): MainScreenEvents()
    data object ReactionClick: MainScreenEvents()
    data object ExpandPostCardClick: MainScreenEvents()
}
