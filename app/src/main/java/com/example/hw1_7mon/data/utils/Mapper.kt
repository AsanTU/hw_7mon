package com.example.hw1_7mon.data.utils

import com.example.hw1_7mon.domain.models.CamerasModel
import com.example.hw1_7mon.domain.models.DoorsModel

fun CamerasModel.mapToCamerasModel() =
    CamerasModel(
        id = id,
        data = data,
        success = success
    )

fun DoorsModel.mapToDoorsModel() =
    DoorsModel(
        id = id,
        data = data,
        success = success
    )