package com.zmitser.reactive.backend.repositories

import com.zmitser.reactive.backend.domain.Movie
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface MovieRepository : ReactiveMongoRepository<Movie, String>{
}