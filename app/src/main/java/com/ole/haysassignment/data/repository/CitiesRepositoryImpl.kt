package com.ole.haysassignment.data.repository

import com.ole.haysassignment.data.remote.CitiesSquareApi
import com.ole.haysassignment.domain.repository.CitiesRepository
import com.ole.haysassignment.data.remote.response.Response
import com.ole.haysassignment.util.Resource
import javax.inject.Inject

class CitiesRepositoryImpl @Inject constructor(
    private val api: CitiesSquareApi
) : CitiesRepository {


    override suspend fun getCities(page: Int, include: String): Resource<Response> {
        if(page<=0) throw Exception()
        val response = try {
            api.getCities(page = page, include = include)
        } catch(e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

    override suspend fun getCitiesContaining(containing: String): Resource<Response>  {
        val response = try {
            api.getCitiesContaining(containing)
        } catch(e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }
}