package ru.aafdev.core_network.models

import com.google.gson.annotations.SerializedName

data class DataResponse(

    @SerializedName("groups")
    val groups: List<GroupResponse>? = null,

    @SerializedName("direction")
    val direction: DirectionResponse? = null
)
