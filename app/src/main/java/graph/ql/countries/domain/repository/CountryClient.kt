package graph.ql.countries.domain.repository

import graph.ql.countries.domain.model.DetailedCountry
import graph.ql.countries.domain.model.SimpleCountry

interface CountryClient {

    suspend fun getCountries(): List<SimpleCountry>
    suspend fun getCountry(code: String): DetailedCountry?
}