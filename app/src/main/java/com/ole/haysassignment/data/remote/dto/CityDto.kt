package com.ole.haysassignment.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CityDto(
    val id: Int,
    val name: String,
    @SerializedName("local_name")
    val localName: String,
    val lat: Long,
    val lng: Long,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("country_id")
    val countryId: Int
)