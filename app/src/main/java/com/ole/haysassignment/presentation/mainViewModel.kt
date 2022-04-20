package com.ole.haysassignment.presentation

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ole.haysassignment.common.Constants
import com.ole.haysassignment.data.remote.response.Item
import com.ole.haysassignment.data.remote.response.Pagination
import com.ole.haysassignment.data.remote.response.Response
import com.ole.haysassignment.data.repository.CitiesRepositoryImpl
import com.ole.haysassignment.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class mainViewModel @Inject constructor(
    val repo: CitiesRepositoryImpl
) : ViewModel() {

    private var _itemList = mutableStateOf(listOf<Item>())
    val itemList: State<List<Item>> = _itemList

    private var _pagination = mutableStateOf(0)
    val pagination: State<Int> = _pagination

    var itemClicked: Item = Item(country_id = 0, created_at = "", id = 0, lat = 0.0, lng = 0.0, local_name = "", name = "", updated_at = "")

    init {
        getCitiesPage(2)
    }

    fun getCitiesPage(Page: Int) {
        viewModelScope.launch {
            val response: Resource<Response> =
                repo.getCities(page = Page, include = Constants.INCLUDE)
            Log.w(TAG, response.data.toString())
            _itemList.value = response.data?.data?.items ?: listOf()
            if(_pagination.value == 0) _pagination.value = response.data?.data?.pagination?.last_page ?: 0
        }
    }

    fun selectItem(itemSelected: Item) {
    itemClicked = itemSelected
    }
}