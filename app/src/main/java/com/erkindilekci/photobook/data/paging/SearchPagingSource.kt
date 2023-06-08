package com.erkindilekci.photobook.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.erkindilekci.photobook.data.remote.UnsplashApi
import com.erkindilekci.photobook.model.Image
import com.erkindilekci.photobook.util.Constants.SEARCH_ITEMS_PER_PAGE

class SearchPagingSource(
    private val api: UnsplashApi,
    private val query: String
) : PagingSource<Int, Image>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Image> {
        val currentPage = params.key ?: 1
        return try {
            val response = api.searchImages(query = query, perPage = SEARCH_ITEMS_PER_PAGE)
            val endOfPaginationReached = response.images.isEmpty()
            if (response.images.isNotEmpty()) {
                LoadResult.Page(
                    data = response.images,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (endOfPaginationReached) null else currentPage + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Image>): Int? {
        return state.anchorPosition
    }
}
