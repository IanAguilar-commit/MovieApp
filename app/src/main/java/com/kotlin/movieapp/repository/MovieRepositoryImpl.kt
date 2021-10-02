package com.kotlin.movieapp.repository

import com.kotlin.movieapp.data.model.MovieList
import com.kotlin.movieapp.data.remote.MovieDataSource

//El repositorio va al data source a buscar información
//Hago referencia al movieData source de Data>remote
// Suspend es corutinas
class MovieRepositoryImpl(private val dataSource: MovieDataSource): MovieRepository{
    override suspend fun getUpcomingMovies(): MovieList = dataSource.getUpcomingMovies()

    override suspend fun getTopRatedMovies(): MovieList = dataSource.getTopRatedMovies()

    override suspend fun getPopularMovies(): MovieList = dataSource.getPopularMovies()
}