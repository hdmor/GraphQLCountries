package graph.ql.countries.domain.use_case

import graph.ql.countries.domain.model.DetailedCountry
import graph.ql.countries.domain.repository.CountryClient

class GetCountryUseCase(private val countryClient: CountryClient) {

    suspend operator fun invoke(code: String): DetailedCountry? =
        countryClient.getCountry(code)
}