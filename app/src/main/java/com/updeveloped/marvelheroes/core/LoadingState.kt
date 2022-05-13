package com.updeveloped.marvelheroes.core

sealed class LoadingState {
    object ShowLoading: LoadingState()
    object HideLoading: LoadingState()
}