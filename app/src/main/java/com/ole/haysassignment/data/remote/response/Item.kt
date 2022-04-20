package com.ole.haysassignment.data.remote.response

data class Item(
    val country_id: Int,
    val created_at: String,
    val id: Int,
    val lat: Double,
    val lng: Double,
    val local_name: String,
    val name: String,
    val updated_at: String
)