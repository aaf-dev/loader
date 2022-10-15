package ru.aafdev.core_ui.mappers

import ru.aafdev.core_data.models.NetologyDataDomainModel
import ru.aafdev.core_ui.models.NetologyDataUiModel

class DataDomainModelToUiModelMapper(
    private val groupMapper: GroupDomainModelToUiModelMapper,
    private val directionMapper: DirectionDomainModelToUiModelMapper
) : (NetologyDataDomainModel) -> NetologyDataUiModel {

    override fun invoke(model: NetologyDataDomainModel): NetologyDataUiModel {
        return NetologyDataUiModel(
            groups = model.groups.map(groupMapper),
            direction = directionMapper(model.direction)
        )
    }
}