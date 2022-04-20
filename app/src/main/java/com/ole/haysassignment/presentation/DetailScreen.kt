package com.ole.haysassignment.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@Composable
fun DetailListScreen(viewModel: mainViewModel, navController: NavController) {

    Row {
        Column() {

            Text(
                modifier = Modifier.padding(2.dp),
                fontSize = 16.sp,
                text = "Name: ${viewModel.itemClicked.name}"
            )
            Text(
                modifier = Modifier.padding(2.dp),
                fontSize = 16.sp,
                text = "Local name: ${viewModel.itemClicked.local_name}"
            )
            Text(
                modifier = Modifier.padding(2.dp),
                fontSize = 16.sp,
                text = "Latitud: ${viewModel.itemClicked.lat}"
            )
            Text(
                modifier = Modifier.padding(2.dp),
                fontSize = 16.sp,
                text = "Longitude: ${viewModel.itemClicked.lng}"
            )

        }
        Spacer(Modifier.width(20.dp))
        Button(
            onClick = { navController.popBackStack() }) {
            Text(text = "Back")
        }
    }
}
