package ru.aafdev.core_network.models

import com.google.gson.annotations.SerializedName

data class GroupResponse(

    @SerializedName("id")
    val id: String? = null,

    @SerializedName("link")
    val link: String? = null,

    @SerializedName("badge")
    val badge: BadgeResponse? = null,

    @SerializedName("items")
    val items: List<ItemResponse>? = null
)
