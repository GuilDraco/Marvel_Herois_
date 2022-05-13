package com.updeveloped.marvelheroes.core

abstract class UseCase<Source> {
    abstract suspend fun execute(): Source
}