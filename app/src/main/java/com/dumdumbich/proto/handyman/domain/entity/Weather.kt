package com.dumdumbich.proto.handyman.domain.entity


data class Weather(
    val temperature: Int,
    val pressure: Int,
    val humidity: Int
) {

    fun temperatureAboveZero() = temperature > 0

}
