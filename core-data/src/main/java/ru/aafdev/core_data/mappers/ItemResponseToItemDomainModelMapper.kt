package ru.aafdev.core_data.mappers

import ru.aafdev.core_data.models.ItemDomainModel
import ru.aafdev.core_network.models.ItemResponse

internal class ItemResponseToItemDomainModelMapper(
    private val badgeMapper: BadgeResponseToBadgeDomainModelMapper
) : (ItemResponse) -> ItemDomainModel {

    override fun invoke(response: ItemResponse): ItemDomainModel {
        return ItemDomainModel(
            id = response.id.orEmpty(),
            link = response.link.orEmpty(),
            badge = badgeMapper(response.badge),
            title = response.title.orEmpty()
        )
    }
}