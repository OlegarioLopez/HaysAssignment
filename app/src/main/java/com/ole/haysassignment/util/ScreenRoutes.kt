package com.ole.haysassignment.util

const val LIST_SCREEN = "ListScreen"
const val DETAIL_SCREEN = "DetailListScreen"
const val MAP_SCREEN = "MapScreen"

sealed class ScreenRoutes(val route: String) {
    object ListScreen : ScreenRoutes(LIST_SCREEN)
    object DetailListScreen : ScreenRoutes(DETAIL_SCREEN)
    object MapScreen: ScreenRoutes(MAP_SCREEN)
}
