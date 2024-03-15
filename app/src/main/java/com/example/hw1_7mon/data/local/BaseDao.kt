package com.example.hw1_7mon.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hw1_7mon.data.local.models.CamerasEntity
import com.example.hw1_7mon.data.local.models.DoorsEntity

@Dao
interface BaseDao {

    @Insert
    fun insertCamerasModel(model: CamerasEntity)

    @Insert
    fun insertDoorsModel(model: DoorsEntity)

    @Query("SELECT COUNT(*) FROM camera_model")
    fun getCamerasCount(): Int

    @Query("SELECT count(*) FROM doors_data")
    fun getDoorsCount(): Int
}