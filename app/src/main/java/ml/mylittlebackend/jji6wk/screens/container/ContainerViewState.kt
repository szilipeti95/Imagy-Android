package ml.mylittlebackend.jji6wk.screens.container

sealed class ContainerViewState

data class ContainerReady(val name: String) : ContainerViewState()