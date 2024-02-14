package graph.ql.countries.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import graph.ql.countries.presentation.ui.theme.GraphQLCountriesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphQLCountriesTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val viewModel = hiltViewModel<CountriesViewModel>()
                    val state = viewModel.state.collectAsState().value
                    CountriesScreen(
                        state = state,
                        onSelectedCountry = viewModel::selectCountry,
                        onDismissCountryDialog = viewModel::dismissCountryDialog
                    )
                }
            }
        }
    }
}