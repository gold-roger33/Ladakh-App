package com.example.ladakh.ui

import androidx.lifecycle.ViewModel
import com.example.ladakh.DataSources.DataSources
import com.example.ladakh.model.DetialedScreenData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LadakhViewModel: ViewModel() {

    private  val _uiState = MutableStateFlow<Int?>(null)
    val uiState:StateFlow<Int?> = _uiState.asStateFlow()

    fun  setCategory(categoryId: Int){
        _uiState.value = categoryId
    }

    fun getDetailedItem(categoryId: Int,itemId: Int) : DetialedScreenData?{
        val categoryItems = DataSources.DetialedScreenItems[categoryId] ?: return  null

        return categoryItems.getOrNull(itemId-1)
    }

}