package com.zmitser.reactive.backend

import com.zmitser.reactive.backend.domain.Movie
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import reactor.core.publisher.toFlux
import java.util.*

@SpringBootApplication
class BackendApplication


fun main(args: Array<String>) {
    SpringApplication.run(BackendApplication::class.java, *args)
}
