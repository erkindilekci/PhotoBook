package com.erkindilekci.photobook.presentation.listscreen

import androidx.lifecycle.ViewModel
import com.erkindilekci.photobook.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    repository: Repository
) : ViewModel() {

    val images = repository.getAllImages()
}
