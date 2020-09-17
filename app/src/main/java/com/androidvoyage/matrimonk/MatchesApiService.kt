package com.androidvoyage.matrimonk

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://randomuser.me"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface MatchesApiService{

    @GET("/api/")
    fun getListMatches(@Query("results") itemPerPage : Int): Call<String>
}

object MatchesApi {
    val retrofitService : MatchesApiService by lazy {
        retrofit.create(MatchesApiService::class.java)
    }
}