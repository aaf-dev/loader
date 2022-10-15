package ru.aafdev.core_data

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.aafdev.core_data.mappers.*
import ru.aafdev.core_data.models.*
import ru.aafdev.core_network.models.*

class MappersTest {

    private val badgeResponse: BadgeResponse = BadgeResponse()
    private val badgeDomainModel: BadgeDomainModel = BadgeDomainModel(
        text = "",
        color = "",
        bgColor = ""
    )
    private val badgeMapper: BadgeResponseToBadgeDomainModelMapper =
        BadgeResponseToBadgeDomainModelMapper()

    private val itemResponse: ItemResponse = ItemResponse()
    private val itemDomainModel: ItemDomainModel = ItemDomainModel(
        id = "",
        link = "",
        badge = null,
        title = ""
    )
    private val itemMapper: ItemResponseToItemDomainModelMapper =
        ItemResponseToItemDomainModelMapper(badgeMapper)

    private val groupResponse: GroupResponse = GroupResponse()
    private val groupDomainModel: GroupDomainModel = GroupDomainModel(
        id = "",
        link = "",
        badge = null,
        items = emptyList()
    )
    private val groupMapper: GroupResponseToGroupDomainModelMapper =
        GroupResponseToGroupDomainModelMapper(badgeMapper = badgeMapper, itemMapper)

    private val directionResponse: DirectionResponse = DirectionResponse()
    private val directionDomainModel: DirectionDomainModel = DirectionDomainModel(
        id = "",
        link = "",
        badge = null,
        title = ""
    )
    private val directionMapper: DirectionResponseToDirectionDomainModelMapper =
        DirectionResponseToDirectionDomainModelMapper(badgeMapper = badgeMapper)

    private val dataResponse: DataResponse = DataResponse()
    private val dataDomainModel: NetologyDataDomainModel = NetologyDataDomainModel(
        groups = emptyList(),
        direction = null
    )
    private val dataMapper: DataResponseToDataDomainModelMapper =
        DataResponseToDataDomainModelMapper(groupMapper = groupMapper, directionMapper = directionMapper)

    @Test
    fun `check that badge mapper map network response correctly`() {
        val result = badgeMapper(badgeResponse)

        assertEquals(result, badgeDomainModel)
    }

    @Test
    fun `check that item mapper map network response correctly`() {
        val result = itemMapper(itemResponse)

        assertEquals(result, itemDomainModel)
    }

    @Test
    fun `check that group mapper map network response correctly`() {
        val result = groupMapper(groupResponse)

        assertEquals(result, groupDomainModel)
    }

    @Test
    fun `check that direction mapper map network response correctly`() {
        val result = directionMapper(directionResponse)

        assertEquals(result, directionDomainModel)
    }

    @Test
    fun `check that data mapper map network response correctly`() {
        val result = dataMapper(dataResponse)

        assertEquals(result, dataDomainModel)
    }
}