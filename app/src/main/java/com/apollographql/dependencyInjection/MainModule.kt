package com.apollographql.dependencyInjection

import com.apollographql.main.data.CountriesAPI
import com.apollographql.main.networking.ApolloClient
import com.apollographql.main.presentation.ViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModule {

    @Provides
    @Singleton
    fun provideClient(): CountriesAPI =
        ApolloClient()

    @Provides
    @Singleton
    fun provideViewModel(client: CountriesAPI): ViewModel =
        ViewModel(client)
}