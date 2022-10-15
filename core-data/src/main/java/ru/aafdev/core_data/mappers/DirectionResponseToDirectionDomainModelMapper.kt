package ru.aafdev.core_data.mappers

import ru.aafdev.core_data.models.DirectionDomainModel
import ru.aafdev.core_network.models.DirectionResponse

internal class DirectionResponseToDirectionDomainModelMapper(
    private val badgeMapper: BadgeResponseToBadgeDomainModelMapper
) : (DirectionResponse?) -> DirectionDomainModel? {

    override fun invoke(response: DirectionResponse?): DirectionDomainModel? {
        if (response == null) return null

        return DirectionDomainModel(
            id = response.id.orEmpty(),
            link = response.link.orEmpty(),
            badge = badgeMapper(response.badge),
            title = response.title.orEmpty()
        )
    }
}