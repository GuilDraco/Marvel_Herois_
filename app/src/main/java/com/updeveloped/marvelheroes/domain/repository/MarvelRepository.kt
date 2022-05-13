package com.updeveloped.marvelheroes.domain.repository

import androidx.paging.PagingData
import com.updeveloped.marvelheroes.domain.entities.CharacterDetail
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {
    suspend fun getMarvelCharactersPage() : Flow<PagingData<CharacterDetail>>
    suspend fun getMarvelCharacters() : List<CharacterDetail>
}