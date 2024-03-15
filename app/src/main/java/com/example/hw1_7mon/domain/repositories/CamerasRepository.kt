package com.example.hw1_7mon.domain.repositories

import com.example.hw1_7mon.data.utils.Resource
import com.example.hw1_7mon.domain.models.CamerasModel
import kotlinx.coroutines.flow.Flow

interface CamerasRepository {
    suspend fun getCameras(): Flow<Resource<CamerasModel>>
}