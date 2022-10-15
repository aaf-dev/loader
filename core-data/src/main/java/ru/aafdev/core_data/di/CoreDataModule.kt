package ru.aafdev.core_data.di

import org.koin.dsl.module
import ru.aafdev.core_data.NetworkRepository
import ru.aafdev.core_data.NetworkRepositoryImpl
import ru.aafdev.core_data.mappers.*
import ru.aafdev.core_data.mappers.BadgeResponseToBadgeDomainModelMapper
import ru.aafdev.core_data.mappers.DataResponseToDataDomainModelMapper
import ru.aafdev.core_data.mappers.DirectionResponseToDirectionDomainModelMapper
import ru.aafdev.core_data.mappers.GroupResponseToGroupDomainModelMapper

val coreDataModule = module {
    single<NetworkRepository> { NetworkRepositoryImpl(networkService = get(), mapper = get()) }

    single { DataResponseToDataDomainModelMapper(groupMapper = get(), directionMapper = get()) }
    single { GroupResponseToGroupDomainModelMapper(badgeMapper = get(), itemMapper = get()) }
    single { DirectionResponseToDirectionDomainModelMapper(badgeMapper = get()) }
    single { ItemResponseToItemDomainModelMapper(badgeMapper = get()) }
    single { BadgeResponseToBadgeDomainModelMapper() }
}