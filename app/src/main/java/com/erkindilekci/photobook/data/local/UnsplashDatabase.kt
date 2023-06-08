package com.erkindilekci.photobook.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.erkindilekci.photobook.data.local.dao.ImageDao
import com.erkindilekci.photobook.data.local.dao.RemoteKeysDao
import com.erkindilekci.photobook.model.Image
import com.erkindilekci.photobook.model.RemoteKeys

@Database(entities = [Image::class, RemoteKeys::class], version = 1, exportSchema = false)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun imageDao(): ImageDao
    abstract fun remoteKeysDao(): RemoteKeysDao
}
