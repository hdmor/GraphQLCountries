package graph.ql.countries.di

import com.apollographql.apollo3.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import graph.ql.countries.data.repository.ApolloCountryClient
import graph.ql.countries.domain.repository.CountryClient
import graph.ql.countries.domain.use_case.GetCountriesUseCase
import graph.ql.countries.domain.use_case.GetCountryUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient = ApolloClient.Builder().serverUrl("https://countries.trevorblades.com/graphql").build()

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient): CountryClient = ApolloCountryClient(apolloClient)

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(countryClient: CountryClient): GetCountriesUseCase = GetCountriesUseCase(countryClient)

    @Provides
    @Singleton
    fun provideGetCountryUseCase(countryClient: CountryClient): GetCountryUseCase = GetCountryUseCase(countryClient)
}