package com.erkindilekci.photobook.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.erkindilekci.photobook.data.local.UnsplashDatabase
import com.erkindilekci.photobook.data.paging.RemoteMediator
import com.erkindilekci.photobook.data.paging.SearchPagingSource
import com.erkindilekci.photobook.data.remote.UnsplashApi
import com.erkindilekci.photobook.model.Image
import com.erkindilekci.photobook.util.Constants.ITEMS_PER_PAGE
import com.erkindilekci.photobook.util.Constants.SEARCH_ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class Repository @Inject constructor(
    private val api: UnsplashApi,
    private val db: UnsplashDatabase
) {
    fun getAllImages(): Flow<PagingData<Image>> {
        val pagingSourceFactory = { db.imageDao().getAllImages() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = RemoteMediator(api, db),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    fun searchImages(query: String): Flow<PagingData<Image>> {
        return Pager(
            config = PagingConfig(pageSize = SEARCH_ITEMS_PER_PAGE),
            pagingSourceFactory = { SearchPagingSource(api, query) }
        ).flow
    }
}
