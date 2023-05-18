package com.example.kitsugithub.models

import com.google.gson.annotations.SerializedName

data class KitsuResponse<T>(

    @SerializedName("data")
    val data: List<T>,
    @SerializedName("links")
    val links: Links
)