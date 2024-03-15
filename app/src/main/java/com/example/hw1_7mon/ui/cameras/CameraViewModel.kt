package com.example.hw1_7mon.ui.cameras

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw1_7mon.data.utils.Resource
import com.example.hw1_7mon.domain.models.CamerasModel
import com.example.hw1_7mon.domain.usecase.GetCamerasUseCase
import com.example.hw1_7mon.domain.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CameraViewModel @Inject constructor(
    private val getCamerasUseCase: GetCamerasUseCase
) : ViewModel() {
    private var _camerasFlow = MutableStateFlow<UiState<CamerasModel>>(UiState.Loading())
    var camerasFlow: StateFlow<UiState<CamerasModel>> = _camerasFlow

    suspend fun getCameras() {
        viewModelScope.launch {
            getCamerasUseCase.getCameras().collect {
                when (it) {
                    is Resource.Error -> _camerasFlow.value = UiState.Error(it.message)
                    is Resource.Loading -> _camerasFlow.value = UiState.Loading()
                    is Resource.Success -> {
                        if (it.data != null) {
                            _camerasFlow.value = UiState.Success(it.data)
                        } else {
                            _camerasFlow.value = UiState.Empty("DATA IS EMPTY")
                        }
                    }
                }
            }
        }
    }
}