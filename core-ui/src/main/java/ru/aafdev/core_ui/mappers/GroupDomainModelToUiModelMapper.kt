package ru.aafdev.core_ui.mappers

import ru.aafdev.core_data.models.GroupDomainModel
import ru.aafdev.core_ui.models.GroupUiModel

class GroupDomainModelToUiModelMapper(
    private val badgeMapper: BadgeDomainModelToUiModelMapper,
    private val itemMapper: ItemDomainModelToUiModelMapper
) : (GroupDomainModel) -> GroupUiModel {
    override fun invoke(model: GroupDomainModel): GroupUiModel {
        return GroupUiModel(
            id = model.id,
            link = model.link,
            badgeUiModel = badgeMapper(model.badge),
            items = model.items.map(itemMapper)
        )
    }
}