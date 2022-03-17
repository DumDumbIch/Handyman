package com.dumdumbich.proto.handyman.data.net.weather.openweathermap

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
        const val OKHTTP_CONNECT_TIMEOUT = 10L
        const val OKHTTP_WRITE_TIMEOUT = 30L
        const val OKHTTP_READ_TIMEOUT = 30L
    }

    // Request example: https://api.openweathermap.org/data/2.5/weather?q=Ivanovo&appid=054672b821fe786c32b2dd520f9bd1b8&units=metric
    @GET("weather")
    fun getCurrentWeather(
        @Query("q") city: String,
        @Query("units") units: String
    ): Call<OpenWeatherMapDto>

}


data class OpenWeatherMapDto(
    @SerializedName("coord") val coordinate: CoordDto,
    @SerializedName("weather") val weather: List<WeatherDto>,
    @SerializedName("base") val base: String,
    @SerializedName("main") val main: MainDto,
    @SerializedName("visibility") val visibility: Long,
    @SerializedName("wind") val wind: WindDto,
    @SerializedName("clouds") val clouds: CloudsDto,
    @SerializedName("dt") val dt: Long,
    @SerializedName("sys") val sys: SysDto,
    @SerializedName("timezone") val timezone: Long,
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("cod") val cod: Long
)

data class CloudsDto(
    @SerializedName("all") val all: Long
)

data class CoordDto(
    @SerializedName("lon") val longitude: Double,
    @SerializedName("lat") val latitude: Double
)

data class MainDto(
    @SerializedName("temp") val temperature: Double,
    @SerializedName("feels_like") val feelsLike: Double,
    @SerializedName("temp_min") val temperatureMin: Double,
    @SerializedName("temp_max") val temperatureMax: Double,
    @SerializedName("pressure") val pressure: Long,
    @SerializedName("humidity") val humidity: Long,
    @SerializedName("sea_level") val seaLevel: Long,
    @SerializedName("grnd_level") val groundLevel: Long
)

data class SysDto(
    @SerializedName("country") val country: String,
    @SerializedName("sunrise") val sunrise: Long,
    @SerializedName("sunset") val sunset: Long
)

data class WeatherDto(
    @SerializedName("id") val id: Long,
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String
)

data class WindDto(
    @SerializedName("speed") val speed: Double,
    @SerializedName("deg") val direction: Long,
    @SerializedName("gust") val gust: Double
)