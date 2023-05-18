package com.example.kitsugithub.models

import com.example.kitsugithub.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class DataItem(
    @SerializedName("id")
    override val id: String,
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("type")
    val type: String
) : IBaseDiffModel
