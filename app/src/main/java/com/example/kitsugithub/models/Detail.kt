package com.example.kitsugithub.models

import com.google.gson.annotations.SerializedName

data class Detail(
    @SerializedName("data")
    val dataItem: DataItem
)
