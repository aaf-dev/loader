package ru.aafdev.core_data

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import ru.aafdev.core_data.mappers.*
import ru.aafdev.core_data.models.NetologyDataDomainModel
import ru.aafdev.core_network.NetworkService
import ru.aafdev.core_network.models.NetologyResponse

class NetworkRepositoryTest {

    private val networkResponse: NetologyResponse = NetologyResponse()
    private val mappedDomainResponse: List<NetologyDataDomainModel> = emptyList()

    private val networkService: NetworkService = mock {
        onBlocking { getData() } doReturn networkResponse
    }

    private val mapper: DataResponseToDataDomainModelMapper = createMapper()

    private val repository: NetworkRepository = NetworkRepositoryImpl(networkService, mapper)

    @Test
    fun `check that network response returns and map correct answer`() {
        val result = runBlocking { repository.getData() }

        assertEquals(result, mappedDomainResponse)
    }

    private fun createMapper(): DataResponseToDataDomainModelMapper {
        val badgeMapper = BadgeResponseToBadgeDomainModelMapper()
        val itemMapper = ItemResponseToItemDomainModelMapper(badgeMapper)
        val groupMapper = GroupResponseToGroupDomainModelMapper(badgeMapper = badgeMapper, itemMapper)
        val directionMapper = DirectionResponseToDirectionDomainModelMapper(badgeMapper = badgeMapper)
        return DataResponseToDataDomainModelMapper(groupMapper = groupMapper, directionMapper = directionMapper)
    }
}
