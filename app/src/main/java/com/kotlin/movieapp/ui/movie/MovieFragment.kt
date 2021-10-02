package com.kotlin.movieapp.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.kotlin.movieapp.R
import com.kotlin.movieapp.core.Resource
import com.kotlin.movieapp.data.remote.MovieDataSource
import com.kotlin.movieapp.databinding.FragmentMovieBinding
import com.kotlin.movieapp.presentation.MovieViewModel
import com.kotlin.movieapp.presentation.MovieViewModelFactory
import com.kotlin.movieapp.repository.MovieRepositoryImpl
import com.kotlin.movieapp.repository.RetrofitClient


class MovieFragment : Fragment(R.layout.fragment_movie) {

    private lateinit var binding: FragmentMovieBinding
    private val viewModel by viewModels<MovieViewModel> { MovieViewModelFactory(MovieRepositoryImpl(
        MovieDataSource(RetrofitClient.webservice)
    )) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)

        viewModel.fetchMainScreenMovies().observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Resource.Loading -> {
                    Log.d("LiveData", "Loading")
                }
                is Resource.Success -> {
                    Log.d("LiveData", "Upcoming: ${result.data.first} \n \n TopRated: ${result.data.second} \n \n Popular: ${result.data.third}")
                }
                is Resource.Failure -> {
                    Log.d("Error", "${result.exception}")
                }
            }
        })
    }

}