package com.dumdumbich.proto.handyman.data.net

import com.dumdumbich.proto.handyman.data.net.weather.openweathermap.OpenWeatherMap
import com.dumdumbich.proto.handyman.domain.entity.Weather
import com.dumdumbich.proto.handyman.domain.usecase.WeatherUseCase


class WeatherDataSource : WeatherUseCase {

    private val openWeatherMap: WeatherUseCase by lazy { OpenWeatherMap() }


    override fun getCurrentWeather(
        city: String,
        onSuccess: (Weather) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        openWeatherMap.getCurrentWeather(city, onSuccess, onError)
    }

}