package com.erkindilekci.photobook.presentation.searchscreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.erkindilekci.photobook.data.repository.Repository
import com.erkindilekci.photobook.model.Image
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery = _searchQuery

    private val _searchedImages = MutableStateFlow<PagingData<Image>>(PagingData.empty())
    val searchedImages: StateFlow<PagingData<Image>> = _searchedImages.asStateFlow()

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun searchImages(query: String) {
        viewModelScope.launch {
            repository.searchImages(query).cachedIn(viewModelScope).collect { pagingData ->
                _searchedImages.value = pagingData
            }
        }
    }
}
