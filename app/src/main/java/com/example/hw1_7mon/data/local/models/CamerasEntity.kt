package com.example.hw1_7mon.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "camera_model")
data class CamerasEntity(
    @PrimaryKey
    var id: Int? = null,
    val count: Int
)