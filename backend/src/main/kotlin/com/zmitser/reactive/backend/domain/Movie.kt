package com.zmitser.reactive.backend.domain

import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Movie(val id: String, val title:String)