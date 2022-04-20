package com.ole.haysassignment.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.ole.haysassignment.data.remote.response.Item

@Composable
fun MapGoogle(viewModel: mainViewModel, navController: NavController){
    val item = viewModel.itemClicked
    val marker = LatLng(item.lat,item.lng)
    GoogleMap(
        Modifier.fillMaxSize(),
        cameraPositionState = CameraPositionState(CameraPosition.fromLatLngZoom(marker,10f))
    ){
        Marker(position = marker, title = item.name, snippet = "ID" + item.id)
    }
}