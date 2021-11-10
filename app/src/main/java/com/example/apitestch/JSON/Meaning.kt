package com.example.apitestch.JSON

import com.example.apitestch.JSON.Definition

data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)