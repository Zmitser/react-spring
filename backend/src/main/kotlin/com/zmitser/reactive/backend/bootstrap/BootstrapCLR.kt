package com.zmitser.reactive.backend.bootstrap

import com.zmitser.reactive.backend.domain.Movie
import com.zmitser.reactive.backend.repositories.MovieRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.publisher.toFlux
import java.util.*

@Component
class BootstrapCLR constructor(val movieRepository: MovieRepository) : CommandLineRunner {


    override fun run(vararg args: String?) {

        movieRepository.deleteAll().thenMany(
                arrayOf("Silence of the Lambdas",
                        "AEon Flux",
                        "Enter the Mono<Void>",
                        "The Fluxxinator",
                        "Back to the Future",
                        "Meet the Fluxes",
                        "Lord of the Fluxes").toFlux()
                        .map { Movie(UUID.randomUUID().toString(), it) }
                .flatMap { movieRepository.save(it) })
                .subscribe(null, null, { movieRepository.findAll().subscribe { println(it) } }
                )
    }

}