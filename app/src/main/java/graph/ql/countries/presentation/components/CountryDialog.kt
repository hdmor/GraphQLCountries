package graph.ql.countries.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import graph.ql.countries.domain.model.DetailedCountry

@Composable
fun CountryDialog(country: DetailedCountry, modifier: Modifier = Modifier, onDismissDialog: () -> Unit) {

    val joinedLanguages = remember(country.language) { country.language.joinToString() }

    Dialog(onDismissRequest = onDismissDialog) {
        Column(modifier = modifier) {
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(text = country.emoji, fontSize = 30.sp)
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = country.name, fontSize = 24.sp)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Continent: ${country.continent}")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Currency: ${country.currency}")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Capital: ${country.capital}")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Language(s): $joinedLanguages")
            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}