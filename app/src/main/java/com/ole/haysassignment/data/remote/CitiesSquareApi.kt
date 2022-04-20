package com.ole.haysassignment.data.remote

import com.ole.haysassignment.data.remote.response.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface CitiesSquareApi {

    @GET("city")
    suspend fun getCities(
        @Query("page") page: Int,
        @Query("include") include: String
    ): Response

    @GET("/city?filter[0][name][contains]=kab")
    suspend fun getCitiesContaining(@Path("name") coinId: String): Response //TODO ver como se hace esta petición
}