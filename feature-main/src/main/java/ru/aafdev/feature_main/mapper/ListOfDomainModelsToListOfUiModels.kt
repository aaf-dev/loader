package ru.aafdev.feature_main.mapper

import ru.aafdev.core_data.models.NetologyDataDomainModel
import ru.aafdev.core_ui.mappers.DataDomainModelToUiModelMapper
import ru.aafdev.core_ui.models.NetologyDataUiModel

class ListOfDomainModelsToListOfUiModels(
    private val dataMapper: DataDomainModelToUiModelMapper
) : (List<NetologyDataDomainModel>) -> List<NetologyDataUiModel> {
    override fun invoke(domainList: List<NetologyDataDomainModel>): List<NetologyDataUiModel> {
        return domainList.map(dataMapper)
    }
}