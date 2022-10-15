package ru.aafdev.core_data.mappers

import ru.aafdev.core_data.models.NetologyDataDomainModel
import ru.aafdev.core_network.models.DataResponse

internal class DataResponseToDataDomainModelMapper(
    private val groupMapper: GroupResponseToGroupDomainModelMapper,
    private val directionMapper: DirectionResponseToDirectionDomainModelMapper
) : (DataResponse) -> NetologyDataDomainModel {
    override fun invoke(response: DataResponse): NetologyDataDomainModel {
        return NetologyDataDomainModel(
            groups = response.groups?.map(groupMapper).orEmpty(),
            direction = directionMapper(response.direction)
        )
    }
}