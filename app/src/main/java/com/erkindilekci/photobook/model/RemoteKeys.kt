package com.erkindilekci.photobook.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.erkindilekci.photobook.util.Constants.UNSPLASH_REMOTE_KEYS_TABLE

@Entity(tableName = UNSPLASH_REMOTE_KEYS_TABLE)
data class RemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val prevPage: Int?,
    val nextPage: Int?
)
