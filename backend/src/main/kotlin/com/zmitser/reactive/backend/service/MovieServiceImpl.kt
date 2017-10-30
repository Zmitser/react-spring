package com.zmitser.reactive.backend.service

import com.zmitser.reactive.backend.domain.Movie
import com.zmitser.reactive.backend.domain.MovieEvent
import com.zmitser.reactive.backend.repositories.MovieRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.time.LocalDateTime

@Service
class MovieServiceImpl(val movieRepository: MovieRepository) : MovieService {

    override fun events(movieId: String): Flux<MovieEvent> {
        return Flux.generate<MovieEvent> {
            it.next(MovieEvent(movieId, LocalDateTime.now()))
        }.delayElements(Duration.ofSeconds(1))
    }


    override fun byId(movieId: String): Mono<Movie>  = movieRepository.findById(movieId)

    override fun all(): Flux<Movie>  = movieRepository.findAll()
}