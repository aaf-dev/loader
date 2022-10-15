package ru.aafdev.core_ui

import org.junit.Test

import org.junit.Assert.*
import ru.aafdev.core_data.models.*
import ru.aafdev.core_ui.mappers.*
import ru.aafdev.core_ui.models.*

class MappersTest {

    private val badgeDomainModel: BadgeDomainModel = BadgeDomainModel(
        text = "",
        color = "",
        bgColor = ""
    )
    private val badgeUiModel: BadgeUiModel = BadgeUiModel(
        text = "",
        color = "",
        bgColor = ""
    )
    private val badgeUiMapper: BadgeDomainModelToUiModelMapper =
        BadgeDomainModelToUiModelMapper()

    private val itemDomainModel: ItemDomainModel = ItemDomainModel(
        id = "",
        link = "",
        badge = null,
        title = ""
    )
    private val itemUiModel: ItemUiModel = ItemUiModel(
        id = "",
        link = "",
        badge = null,
        title = ""
    )
    private val itemUiMapper: ItemDomainModelToUiModelMapper =
        ItemDomainModelToUiModelMapper(badgeMapper = badgeUiMapper)

    private val groupDomainModel: GroupDomainModel = GroupDomainModel(
        id = "",
        link = "",
        badge = null,
        items = emptyList()
    )
    private val groupUiModel: GroupUiModel = GroupUiModel(
        id = "",
        link = "",
        badgeUiModel = null,
        items = emptyList()
    )
    private val groupUiMapper: GroupDomainModelToUiModelMapper =
        GroupDomainModelToUiModelMapper(badgeMapper = badgeUiMapper, itemMapper = itemUiMapper)

    private val directionDomainModel: DirectionDomainModel = DirectionDomainModel(
        id = "",
        link = "",
        badge = null,
        title = ""
    )
    private val directionUiModel: DirectionUiModel = DirectionUiModel(
        id = "",
        link = "",
        badgeUiModel = null,
        title = ""
    )
    private val directionMapper: DirectionDomainModelToUiModelMapper =
        DirectionDomainModelToUiModelMapper(badgeMapper = badgeUiMapper)

    private val dataDomainModel: NetologyDataDomainModel = NetologyDataDomainModel(
        groups = emptyList(),
        direction = null
    )
    private val dataUiModel: NetologyDataUiModel = NetologyDataUiModel(
        groups = emptyList(),
        direction = null
    )
    private val dataUiMapper: DataDomainModelToUiModelMapper =
        DataDomainModelToUiModelMapper(groupMapper = groupUiMapper, directionMapper = directionMapper)

    @Test
    fun `check that badge mapper map domain model to ui model correctly`() {
        val result = badgeUiMapper(badgeDomainModel)

        assertEquals(result, badgeUiModel)
    }

    @Test
    fun `check that item mapper map domain model to ui model correctly`() {
        val result = itemUiMapper(itemDomainModel)

        assertEquals(result, itemUiModel)
    }

    @Test
    fun `check that group mapper map domain model to ui model correctly`() {
        val result = groupUiMapper(groupDomainModel)

        assertEquals(result, groupUiModel)
    }

    @Test
    fun `check that direction mapper map domain model to ui model correctly`() {
        val result = directionMapper(directionDomainModel)

        assertEquals(result, directionUiModel)
    }

    @Test
    fun `check that data mapper map domain model to ui model correctly`() {
        val result = dataUiMapper(dataDomainModel)

        assertEquals(result, dataUiModel)
    }
}