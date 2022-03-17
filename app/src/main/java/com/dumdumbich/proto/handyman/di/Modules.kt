package com.dumdumbich.proto.handyman.di

import com.dumdumbich.proto.handyman.data.net.WeatherDataSource
import com.dumdumbich.proto.handyman.domain.usecase.WeatherUseCase
import com.dumdumbich.proto.handyman.ui.screen.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module {

    single<WeatherUseCase> { WeatherDataSource() }

    viewModel { HomeViewModel(get()) }

}