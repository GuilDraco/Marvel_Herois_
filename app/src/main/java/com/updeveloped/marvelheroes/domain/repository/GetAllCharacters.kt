package com.updeveloped.marvelheroes.domain.repository

import androidx.paging.PagingData
import com.updeveloped.marvelheroes.core.UseCase
import com.updeveloped.marvelheroes.domain.entities.CharacterDetail
import kotlinx.coroutines.flow.Flow

class GetAllCharactersUseCase(private val repository: MarvelRepository) : UseCase<Flow<PagingData<CharacterDetail>>>() {
    override suspend fun execute(): Flow<PagingData<CharacterDetail>> = repository.getMarvelCharactersPage()
}

class GetAllCharacters(private val repository: MarvelRepository) : UseCase<List<CharacterDetail>>() {
    override suspend fun execute(): List<CharacterDetail> = repository.getMarvelCharacters()
}