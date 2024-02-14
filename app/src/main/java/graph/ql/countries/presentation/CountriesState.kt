package graph.ql.countries.presentation

import graph.ql.countries.domain.model.DetailedCountry
import graph.ql.countries.domain.model.SimpleCountry

data class CountriesState(
    val countries: List<SimpleCountry> = emptyList(),
    val isLoading: Boolean = false,
    val selectedCountry: DetailedCountry? = null
)
