package graph.ql.countries.data.mapper

import com.example.CountriesQuery
import com.example.CountryQuery
import graph.ql.countries.domain.model.DetailedCountry
import graph.ql.countries.domain.model.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry =
    DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        currency = currency ?: "No currency",
        capital = capital ?: "No capital",
        language = languages.map { it.toString() },
        continent = continent.name
    )

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry =
    SimpleCountry(code = code, name = name, emoji = emoji, capital = capital ?: "No capital")