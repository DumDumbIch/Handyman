package com.dumdumbich.proto.handyman.ui.screen.home.info

import android.os.Parcelable
import androidx.lifecycle.LiveData
import com.dumdumbich.proto.handyman.domain.entity.Weather

class HomeInfoContract {

    interface ViewState // : Parcelable

    interface ViewModel {
        val weather: LiveData<Weather>
        fun updateWeather()
    }

}