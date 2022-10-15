package ru.aafdev.core_data

import ru.aafdev.core_data.mappers.DataResponseToDataDomainModelMapper
import ru.aafdev.core_data.models.NetologyDataDomainModel
import ru.aafdev.core_network.NetworkService

interface NetworkRepository {
    suspend fun getData(): List<NetologyDataDomainModel>
}

internal class NetworkRepositoryImpl(
    private val networkService: NetworkService,
    private val mapper: DataResponseToDataDomainModelMapper
) : NetworkRepository {

    override suspend fun getData(): List<NetologyDataDomainModel> {
        return networkService.getData().data?.map(mapper).orEmpty()
    }
}
