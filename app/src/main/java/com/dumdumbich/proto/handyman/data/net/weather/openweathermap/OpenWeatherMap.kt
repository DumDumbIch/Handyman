package com.dumdumbich.proto.handyman.data.net.weather.openweathermap

import com.dumdumbich.proto.handyman.BuildConfig
import com.dumdumbich.proto.handyman.data.net.weather.openweathermap.Api.Companion.OKHTTP_CONNECT_TIMEOUT
import com.dumdumbich.proto.handyman.data.net.weather.openweathermap.Api.Companion.OKHTTP_READ_TIMEOUT
import com.dumdumbich.proto.handyman.data.net.weather.openweathermap.Api.Companion.OKHTTP_WRITE_TIMEOUT
import com.dumdumbich.proto.handyman.domain.entity.Weather
import com.dumdumbich.proto.handyman.domain.usecase.WeatherUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class OpenWeatherMap : WeatherUseCase {

    private val retrofit = Retrofit.Builder()
        .baseUrl(Api.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(createHttpClient())
        .build()

    private val api = retrofit.create(Api::class.java)


    private fun createHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                chain.proceed(chain
                    .request().run {
                        val url = url
                            .newBuilder()
                            .addQueryParameter("appid", BuildConfig.OPEN_WEATHER_MAP_API_KEY)
                            .build()

                        newBuilder()
                            .url(url)
                            .build()
                    }
                )
            }
            .connectTimeout(OKHTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(OKHTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(OKHTTP_READ_TIMEOUT, TimeUnit.SECONDS)
            .apply {
                if (BuildConfig.DEBUG) {
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                        addInterceptor(this)
                    }
                }
            }
            .build()
    }

    override fun getCurrentWeather(
        city: String,
        onSuccess: (Weather) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        api.getCurrentWeather(city, "metric")
            .enqueue(object : Callback<OpenWeatherMapDto> {

                override fun onResponse(
                    call: Call<OpenWeatherMapDto>,
                    response: Response<OpenWeatherMapDto>
                ) {
                    if (response.isSuccessful) {
                        onSuccess(getResultFromDto(response.body()))
                    } else {
                        onError(Throwable("OpenWeatherMap DataSource : unknown error"))
                    }
                }

                override fun onFailure(call: Call<OpenWeatherMapDto>, t: Throwable) {
                    onError(t)
                }

            })
    }

    private fun getResultFromDto(dto: OpenWeatherMapDto?): Weather {
        return dto?.let {
            Weather(
                it.main.temperature.toInt(),
                it.main.pressure.toInt(),
                it.main.humidity.toInt()
            )
        } ?: Weather(99, 2000, 100)
    }

}