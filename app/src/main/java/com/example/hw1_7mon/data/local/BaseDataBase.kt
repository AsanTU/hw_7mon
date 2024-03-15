package com.example.hw1_7mon.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw1_7mon.data.local.models.CamerasEntity
import com.example.hw1_7mon.data.local.models.DoorsEntity

@Database(entities = [CamerasEntity::class, DoorsEntity::class], version = 2)
abstract class BaseDataBase : RoomDatabase() {
    abstract fun homeDao(): BaseDao
}