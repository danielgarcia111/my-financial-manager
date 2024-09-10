package com.example.exemplomvvmlivedatacoroutinesretrofit.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface SeriesService {

    @GET(value = "?t=Game of Thrones&Season=1&apikey=")
    suspend fun getGotSeasonOne(): Series

    @GET(value = "/")
    suspend fun getPoster(
        @Query(value = "i")
        imdbId:String,
        @Query(value = "apiKey")
        apiKey:String = ""
    ): Poster

}

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://omdbapi.com/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

val seriesService: SeriesService = retrofit.create(SeriesService::class.java)
