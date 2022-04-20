package com.ole.haysassignment.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PaginationDto(
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("last_page")
    val lastPage: Int,
    @SerializedName("per_page")
    val perPage: Int,
    val total: Int
)