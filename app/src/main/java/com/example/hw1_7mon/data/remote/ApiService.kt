package com.example.hw1_7mon.data.remote

import com.example.hw1_7mon.domain.models.CamerasModel
import com.example.hw1_7mon.domain.models.DoorsModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("cameras/")
    suspend fun getCameras():Response<CamerasModel>

    @GET("doors/")
    suspend fun getDoors():Response<DoorsModel>
}