package ru.aafdev.core_network.models

import com.google.gson.annotations.SerializedName

data class BadgeResponse(

    @SerializedName("text")
    val text: String? = null,

    @SerializedName("color")
    val color: String? = null,

    @SerializedName("bgColor")
    val bgColor: String? = null
)
