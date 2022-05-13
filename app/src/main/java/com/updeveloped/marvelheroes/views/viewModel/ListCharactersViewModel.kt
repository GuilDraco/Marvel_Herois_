package com.updeveloped.marvelheroes.views.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.updeveloped.marvelheroes.core.DefaultException
import com.updeveloped.marvelheroes.core.LoadingState
import com.updeveloped.marvelheroes.core.State
import com.updeveloped.marvelheroes.domain.entities.CharacterDetail
import com.updeveloped.marvelheroes.domain.repository.GetAllCharacters
import com.updeveloped.marvelheroes.domain.repository.GetAllCharactersUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class ListCharactersViewModel(private val getAllCharactersUseCase: GetAllCharactersUseCase,
                              private val getAllCharacters: GetAllCharacters
) : ViewModel() {

    private val _charactersState = MutableLiveData<State<PagingData<CharacterDetail>>>()
    val charactersState: MutableLiveData<State<PagingData<CharacterDetail>>>
        get() = _charactersState

    private val _characters = MutableLiveData<State<List<CharacterDetail>>>()
    val characters: MutableLiveData<State<List<CharacterDetail>>>
        get() = _characters

    fun getAllCharacters(){
        viewModelScope.launch {
            val it = getAllCharacters.execute()
            _characters.postValue(State.Success(it))
        }
    }

    fun getAllCharactersPage() {
        viewModelScope.launch {
            getAllCharactersUseCase.execute().cachedIn(this)
                .catch {
                    val exception = DefaultException("Não foi possível obter os dados necessários")
                    _charactersState.postValue(State.Error(exception))
                }
                .collect { characters ->
                    _charactersState.postValue(State.Success(characters))
                }
        }
    }
}