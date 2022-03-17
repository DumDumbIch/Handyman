package com.dumdumbich.proto.handyman.ui.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dumdumbich.proto.handyman.domain.entity.Weather
import com.dumdumbich.proto.handyman.domain.usecase.WeatherUseCase


class HomeViewModel(private val weatherDataSource: WeatherUseCase) : ViewModel(),
    HomeContract.ViewModel {

    private data class HomeViewState(
        var weather: Weather = Weather(99, 999, 99)
    )

    private var state: HomeViewState = HomeViewState()

    private val _weather = MutableLiveData<Weather>().apply { value = state.weather }
    override val weather: LiveData<Weather> = _weather


    override fun updateWeather() {
        loadWeather("Ivanovo")
    }

    private fun loadWeather(city: String) {
        weatherDataSource.getCurrentWeather(city,
            onSuccess = { weather ->
                state.weather = weather
                _weather.postValue(state.weather)
            },
            onError = {

            })
    }

}