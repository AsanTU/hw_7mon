package com.example.hw1_7mon.domain.usecase

import com.example.hw1_7mon.domain.repositories.DoorsRepository
import javax.inject.Inject

class GetDoorsUseCase @Inject constructor(private val doorsRepository: DoorsRepository) {
    suspend fun getDoors() = doorsRepository.getDoors()
}