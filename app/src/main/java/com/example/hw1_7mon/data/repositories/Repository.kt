package com.example.hw1_7mon.data.repositories

import com.example.hw1_7mon.data.remote.ApiService
import com.example.hw1_7mon.data.utils.Resource
import com.example.hw1_7mon.data.utils.mapToCamerasModel
import com.example.hw1_7mon.data.utils.mapToDoorsModel
import com.example.hw1_7mon.domain.models.CamerasModel
import com.example.hw1_7mon.domain.models.DoorsModel
import com.example.hw1_7mon.domain.repositories.CamerasRepository
import com.example.hw1_7mon.domain.repositories.DoorsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository(private val apiService: ApiService) : CamerasRepository, DoorsRepository {

    override suspend fun getCameras(): Flow<Resource<CamerasModel>> =
        flow {
            emit(Resource.Loading())
            try {
                val result = apiService.getCameras().body()!!.mapToCamerasModel()
                emit(Resource.Success(result))
            } catch (e: Exception) {
                emit(Resource.Error(e.message))
            }
        }

    override suspend fun getDoors(): Flow<Resource<DoorsModel>> =
        flow {
            emit(Resource.Loading())
            try {
                val result = apiService.getDoors().body()!!.mapToDoorsModel()
                emit(Resource.Success(result))
            } catch (e: Exception) {
                emit(Resource.Error(e.message))
            }
        }

}