package graph.ql.countries.data.repository

import com.apollographql.apollo3.ApolloClient
import com.example.CountriesQuery
import com.example.CountryQuery
import graph.ql.countries.data.mapper.toDetailedCountry
import graph.ql.countries.data.mapper.toSimpleCountry
import graph.ql.countries.domain.repository.CountryClient
import graph.ql.countries.domain.model.DetailedCountry
import graph.ql.countries.domain.model.SimpleCountry

class ApolloCountryClient(private val apolloClient: ApolloClient) : CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> =
        apolloClient.query(CountriesQuery()).execute().data?.countries?.map { it.toSimpleCountry() } ?: emptyList()

    override suspend fun getCountry(code: String): DetailedCountry? =
        apolloClient.query(CountryQuery(code)).execute().data?.country?.toDetailedCountry()
}