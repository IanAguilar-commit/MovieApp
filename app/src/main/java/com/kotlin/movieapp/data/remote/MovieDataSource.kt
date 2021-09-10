package com.kotlin.movieapp.data.remote

import com.kotlin.movieapp.data.model.MovieList

class MovieDataSource {

    fun getUpcomingMovies(): MovieList {
        return MovieList()
    }

    fun getTopRatedMovies(): MovieList {
        return MovieList()
    }
    fun getPopularMovies(): MovieList {
        return MovieList()
    }
    
}