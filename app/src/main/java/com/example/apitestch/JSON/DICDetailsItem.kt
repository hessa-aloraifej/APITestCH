package com.example.apitestch.JSON

data class DICDetailsItem(
    val meanings: List<Meaning>,
    val origin: String,
    val phonetics: List<Any>,
    val word: String
)