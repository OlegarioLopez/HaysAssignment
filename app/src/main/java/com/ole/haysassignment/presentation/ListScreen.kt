package com.ole.haysassignment.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ole.haysassignment.data.remote.response.Item
import com.ole.haysassignment.util.ScreenRoutes
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalMaterialApi
@Composable
fun ListScreen(viewModel: mainViewModel, navController: NavController) {
Column() {
    if (viewModel.pagination.value != 0) {
        Card(
            elevation = 12.dp
        ) {
            LazyRow(
                modifier = Modifier
                    .wrapContentHeight()
                    .background(Color(0xFFBDBBBB))

            ) {
                var ListPages = listOf<Int>()
                for (i in 1..viewModel.pagination.value) {
                    ListPages += i
                }
                items(

                    items = ListPages,
                    itemContent = { currentPage ->
                        Spacer(Modifier.width(5.dp))
                        Text(
                            text = currentPage.toString(),
                            modifier = Modifier.clickable { viewModel.getCitiesPage(currentPage) },
                            color = Color.Blue,
                            fontSize = 24.sp
                        )
                    })
            }
        }
    }
    LazyColumn {
        itemsIndexed(
            items = viewModel.itemList.value,
            key = { _, item ->
                item.hashCode()
            }
        ) { _, item ->
            val state = rememberDismissState(
                confirmStateChange = {
                    if (it == DismissValue.DismissedToStart) {
                        viewModel.selectItem(itemSelected = item)
                        navController.navigate(ScreenRoutes.MapScreen.route)
                    }
                    false
                }
            )
            SwipeToDismiss(
                state = state,
                background = {
                    val color = when (state.dismissDirection) {
                        DismissDirection.StartToEnd -> Color.Transparent
                        DismissDirection.EndToStart -> Color.Blue
                        null -> Color.Transparent
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = color)
                            .padding(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Delete",
                            tint = lightColors().onError,
                            modifier = Modifier.align(Alignment.CenterEnd)
                        )
                    }
                },
                dismissContent = {
                    SampleItems(item, navController = navController, viewModel = viewModel)
                },
                directions = setOf(DismissDirection.EndToStart)
            )
        }
    }

}



}

@Composable
fun SampleItems(item: Item, viewModel: mainViewModel, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.surface)
            .clickable {
                viewModel.selectItem(itemSelected = item)
                navController.navigate(ScreenRoutes.DetailListScreen.route)
            }
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(1.dp)) {

            Text(
                text = item.name,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    12.dp,
                    8.dp
                )
            )
        }
    }
}
