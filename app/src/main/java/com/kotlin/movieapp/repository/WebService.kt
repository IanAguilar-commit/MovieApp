package com.kotlin.movieapp.repository

import com.google.gson.GsonBuilder
import com.kotlin.movieapp.application.AppConstants
import com.kotlin.movieapp.data.model.MovieList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//EL webservice es el encargado de usar retrofit para traer la data del servidor
//Tiene metodos para hacer los llamados al servidor

interface WebService {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") apiKey: String): MovieList

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key") apiKey: String): MovieList

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): MovieList
}

//Retrofit es la instancia que me va a proporcionar la base url, el convertidor y esa instancia con el webservice
object RetrofitClient {

    val webservice: WebService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebService::class.java)
    }
}