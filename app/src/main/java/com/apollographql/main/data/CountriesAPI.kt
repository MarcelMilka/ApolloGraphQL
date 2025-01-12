package com.apollographql.main.data

import com.apollographql.main.buisness.PreviewedCountry

interface CountriesAPI {

    suspend fun getPreviewsOfCountries(): List<PreviewedCountry>?
}