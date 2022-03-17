package com.dumdumbich.proto.handyman.ui.pages.home

import android.os.Parcelable
import androidx.lifecycle.LiveData
import com.dumdumbich.proto.handyman.domain.entity.Weather

class HomeContract {

    interface ViewState : Parcelable

    interface ViewModel {
        val weather: LiveData<Weather>
        fun updateWeather()
    }

}