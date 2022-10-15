package ru.aafdev.core_network.models

import com.google.gson.annotations.SerializedName

data class DirectionResponse(

    @SerializedName("id")
    val id: String? = null,

    @SerializedName("link")
    val link: String? = null,

    @SerializedName("badge")
    val badge: BadgeResponse? = null,

    @SerializedName("title")
    val title: String? = null
)
