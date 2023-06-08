package com.erkindilekci.photobook.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.erkindilekci.photobook.model.Image

@Dao
interface ImageDao {

    @Query("SELECT * FROM unsplash_image_table")
    fun getAllImages(): PagingSource<Int, Image>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addImages(images: List<Image>)

    @Query("DELETE FROM unsplash_image_table")
    suspend fun deleteAllImages()
}
