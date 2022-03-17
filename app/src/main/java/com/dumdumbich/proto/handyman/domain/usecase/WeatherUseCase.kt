package com.dumdumbich.proto.handyman.domain.usecase

import com.dumdumbich.proto.handyman.domain.entity.Weather


interface WeatherUseCase {
    fun getCurrentWeather(
        city: String,
        onSuccess: (Weather) -> Unit,
        onError: (Throwable) -> Unit
    )
}