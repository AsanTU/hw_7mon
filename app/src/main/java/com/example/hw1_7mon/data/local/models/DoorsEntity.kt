package com.example.hw1_7mon.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "doors_data")
data class DoorsEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val count: Int
)
