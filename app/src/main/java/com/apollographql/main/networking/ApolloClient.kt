package com.apollographql.main.networking

import com.apollographql.apollo.ApolloClient
import com.apollographql.main.buisness.PreviewedCountry
import com.apollographql.main.buisness.convertToPreviewedCountry
import com.apollographql.main.data.CountriesAPI
import com.example.rocketreserver.PreviewedCountriesQuery
import javax.inject.Inject

class ApolloClient @Inject constructor(): CountriesAPI {

    private val apolloClient = ApolloClient
        .Builder()
        .serverUrl("https://countries.trevorblades.com/graphql")
        .build()

    override suspend fun getPreviewsOfCountries(): List<PreviewedCountry>? =
        apolloClient
            .query(PreviewedCountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map {

                it.convertToPreviewedCountry()
            }
}