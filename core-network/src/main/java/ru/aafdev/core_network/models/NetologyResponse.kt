package ru.aafdev.core_network.models

import com.google.gson.annotations.SerializedName

data class NetologyResponse(

    @SerializedName("data")
    val data: List<DataResponse>? = null
)
