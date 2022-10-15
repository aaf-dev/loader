package ru.aafdev.core_data.mappers

import ru.aafdev.core_data.models.BadgeDomainModel
import ru.aafdev.core_network.models.BadgeResponse

internal class BadgeResponseToBadgeDomainModelMapper : (BadgeResponse?) -> BadgeDomainModel? {
    override fun invoke(response: BadgeResponse?): BadgeDomainModel? {
        if (response == null) return null

        return BadgeDomainModel(
            text = response.text.orEmpty(),
            color = response.color.orEmpty(),
            bgColor = response.bgColor.orEmpty()
        )
    }
}