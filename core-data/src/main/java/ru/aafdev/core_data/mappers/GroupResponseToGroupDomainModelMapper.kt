package ru.aafdev.core_data.mappers

import ru.aafdev.core_data.models.GroupDomainModel
import ru.aafdev.core_network.models.GroupResponse

internal class GroupResponseToGroupDomainModelMapper(
    private val badgeMapper: BadgeResponseToBadgeDomainModelMapper,
    private val itemMapper: ItemResponseToItemDomainModelMapper
) : (GroupResponse) -> GroupDomainModel {

    override fun invoke(response: GroupResponse): GroupDomainModel {
        return GroupDomainModel(
            id = response.id.orEmpty(),
            link = response.link.orEmpty(),
            badge = badgeMapper(response.badge),
            items = response.items?.map(itemMapper).orEmpty()
        )
    }
}