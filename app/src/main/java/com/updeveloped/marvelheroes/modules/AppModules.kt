package com.updeveloped.marvelheroes.modules

import com.updeveloped.marvelheroes.domain.repository.GetAllCharacters
import com.updeveloped.marvelheroes.domain.repository.GetAllCharactersUseCase
import com.updeveloped.marvelheroes.views.ui.fragment.HomeFragment
import com.updeveloped.marvelheroes.views.viewModel.ListCharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel<ListCharactersViewModel> { ListCharactersViewModel(get(), get()) }
}

val repositoryModule = module {
    single<GetAllCharactersUseCase> { GetAllCharactersUseCase(get()) }
    single<GetAllCharacters> { GetAllCharacters(get()) }
}

val uiModule = module {
    factory<HomeFragment> { HomeFragment() }
}



