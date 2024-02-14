package graph.ql.countries.domain.use_case

import graph.ql.countries.domain.model.SimpleCountry
import graph.ql.countries.domain.repository.CountryClient

class GetCountriesUseCase(private val countryClient: CountryClient) {

    suspend operator fun invoke() : List<SimpleCountry> =
        countryClient.getCountries().sortedBy { it.name }
}