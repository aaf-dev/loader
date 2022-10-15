package ru.aafdev.core_network

import retrofit2.http.GET
import ru.aafdev.core_network.models.NetologyResponse

interface NetworkService {

    @GET("/netology-code/rn-task/master/netology.json")
    suspend fun getData(): NetologyResponse
}