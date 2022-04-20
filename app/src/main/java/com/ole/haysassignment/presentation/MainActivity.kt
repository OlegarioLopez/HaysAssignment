package com.ole.haysassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ole.haysassignment.presentation.ListScreen
import com.ole.haysassignment.presentation.mainViewModel
import com.ole.haysassignment.ui.theme.HaysAssignmentTheme
import com.ole.haysassignment.util.Navigation
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HaysAssignmentTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    Navigation()
                }
            }
        }
    }
}

//TODO USER permission INTERNET ?
@Composable
fun Greeting(
    name: String,
    viewModel: mainViewModel = hiltViewModel()
) {
    Text(text = "Hello $name!")
}
