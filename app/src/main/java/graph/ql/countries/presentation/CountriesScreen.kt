package graph.ql.countries.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import graph.ql.countries.presentation.components.CountryDialog
import graph.ql.countries.presentation.components.CountryItem

@Composable
fun CountriesScreen(state: CountriesState, onSelectedCountry: (code: String) -> Unit, onDismissCountryDialog: () -> Unit) {

    Box(modifier = Modifier.fillMaxSize()) {
        if (state.isLoading) CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.countries) { country ->
                    CountryItem(country = country, modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onSelectedCountry(country.code) }
                        .padding(16.dp))
                    Divider()
                }
            }

            if (state.selectedCountry != null)
                CountryDialog(
                    country = state.selectedCountry,
                    onDismissDialog = onDismissCountryDialog,
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .background(Color.White)
                        .padding(16.dp)
                )
        }
    }
}