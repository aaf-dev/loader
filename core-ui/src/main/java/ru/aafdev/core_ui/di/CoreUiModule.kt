package ru.aafdev.core_ui.di

import org.koin.dsl.module
import ru.aafdev.core_ui.mappers.*

val coreUiModule = module {
    single { DataDomainModelToUiModelMapper(groupMapper = get(), directionMapper = get()) }
    single { GroupDomainModelToUiModelMapper(badgeMapper = get(), itemMapper = get()) }
    single { DirectionDomainModelToUiModelMapper(badgeMapper = get()) }
    single { ItemDomainModelToUiModelMapper(badgeMapper = get()) }
    single { BadgeDomainModelToUiModelMapper() }
}