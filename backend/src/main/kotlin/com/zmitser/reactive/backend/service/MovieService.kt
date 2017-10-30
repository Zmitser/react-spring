package com.zmitser.reactive.backend.service

import com.zmitser.reactive.backend.domain.Movie
import com.zmitser.reactive.backend.domain.MovieEvent
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface MovieService {

    fun events(movieId: String): Flux<MovieEvent>

    fun byId(movieId:String): Mono<Movie>

    fun all(): Flux<Movie>
}