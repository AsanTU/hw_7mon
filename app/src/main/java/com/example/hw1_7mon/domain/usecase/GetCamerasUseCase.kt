package com.example.hw1_7mon.domain.usecase

import com.example.hw1_7mon.domain.repositories.CamerasRepository
import javax.inject.Inject

class GetCamerasUseCase @Inject constructor(private val camerasRepository: CamerasRepository) {
    suspend fun getCameras() = camerasRepository.getCameras()
}