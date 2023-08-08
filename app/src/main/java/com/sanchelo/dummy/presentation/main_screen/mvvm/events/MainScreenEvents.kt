package com.sanchelo.dummy.presentation.main_screen.mvvm.events

sealed class MainScreenEvents {
    data object CardClick: MainScreenEvents()
    data class AddToCart(val id: Int): MainScreenEvents()
    data class AddToFavorites(val id: Int): MainScreenEvents()
    data class ReactionClick(val counter: Int): MainScreenEvents()
}
