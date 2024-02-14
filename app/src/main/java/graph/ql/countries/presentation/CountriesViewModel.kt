package graph.ql.countries.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import graph.ql.countries.domain.use_case.GetCountriesUseCase
import graph.ql.countries.domain.use_case.GetCountryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getCountryUseCase: GetCountryUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CountriesState())
    val state: StateFlow<CountriesState> get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            _state.update { it.copy(countries = getCountriesUseCase(), isLoading = false) }
        }
    }

    fun selectCountry(code: String) {
        viewModelScope.launch {
            _state.update { it.copy(selectedCountry = getCountryUseCase(code)) }
        }
    }

    fun dismissCountryDialog() {
        _state.update { it.copy(selectedCountry = null) }
    }

}