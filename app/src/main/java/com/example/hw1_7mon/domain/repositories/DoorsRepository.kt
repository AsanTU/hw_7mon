package com.example.hw1_7mon.domain.repositories

import com.example.hw1_7mon.data.utils.Resource
import com.example.hw1_7mon.domain.models.DoorsModel
import kotlinx.coroutines.flow.Flow

interface DoorsRepository {
    suspend fun getDoors(): Flow<Resource<DoorsModel>>
}