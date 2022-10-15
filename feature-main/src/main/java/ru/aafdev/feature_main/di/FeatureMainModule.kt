package ru.aafdev.feature_main.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.aafdev.feature_main.mapper.ListOfDomainModelsToListOfUiModels
import ru.aafdev.feature_main.presentation.MainViewModel

val featureMainModule = module {
    viewModel { MainViewModel(networkRepository = get(), mapper = get()) }
    single { ListOfDomainModelsToListOfUiModels(dataMapper = get()) }
}