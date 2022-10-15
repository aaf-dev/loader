package ru.aafdev.loader.di

import org.koin.dsl.module
import ru.aafdev.core_data.di.coreDataModule
import ru.aafdev.core_network.di.coreNetworkModule
import ru.aafdev.core_ui.di.coreUiModule
import ru.aafdev.feature_main.di.featureMainModule

val appModule = module {
    includes(
        coreNetworkModule,
        coreDataModule,
        coreUiModule,
        featureMainModule
    )
}