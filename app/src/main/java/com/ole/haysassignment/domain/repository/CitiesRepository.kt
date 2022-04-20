package com.ole.haysassignment.domain.repository

import com.ole.haysassignment.data.remote.response.Response
import com.ole.haysassignment.util.Resource

interface CitiesRepository {

    suspend fun getCities(page: Int, include: String): Resource<Response>

    suspend fun getCitiesContaining(containing: String): Resource<Response>
}