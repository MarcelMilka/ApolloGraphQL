package com.apollographql.main.buisness

import com.example.rocketreserver.PreviewedCountriesQuery

data class PreviewedCountry (
    val name: String,
    val code: String,
)

fun PreviewedCountriesQuery.Country.convertToPreviewedCountry(): PreviewedCountry =
    PreviewedCountry(this.name, this.code)
