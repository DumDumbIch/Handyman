package com.dumdumbich.proto.handyman.ui.screen.home.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.dumdumbich.proto.handyman.databinding.FragmentHomeInfoBinding
import com.dumdumbich.proto.handyman.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeInfoFragment : BaseFragment() {

    private enum class HomeProgressBar {
        WEATHER, MICROCLIMATE, CALENDAR, STATUS
    }

    private var _ui: FragmentHomeInfoBinding? = null
    private val ui get() = _ui!!

    private val vm: HomeInfoContract.ViewModel by viewModel<HomeInfoViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentHomeInfoBinding.inflate(inflater, container, false).root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _ui = FragmentHomeInfoBinding.bind(view)

        ui.temperatureOutdoorTextView.setOnClickListener {
            showProgressBar(HomeProgressBar.WEATHER)
            vm.updateWeather()
        }

        vm.weather.observe(viewLifecycleOwner) { weather ->
            ui.temperatureOutdoorTextView.text = weather.temperature.toString()
            ui.pressureOutdoorTextView.text = weather.pressure.toString()
            ui.humidityOutdoorTextView.text = weather.humidity.toString()
            hideProgressBar(HomeProgressBar.WEATHER)
        }

    }

    override fun onDestroyView() {
        _ui = null
        super.onDestroyView()
    }


    private fun showProgressBar(progressBar: HomeProgressBar) {
        when (progressBar) {
            HomeProgressBar.WEATHER -> ui.weatherProgressBar.isVisible = true
            HomeProgressBar.MICROCLIMATE -> ui.microclimateProgressBar.isVisible = true
            HomeProgressBar.CALENDAR -> ui.calendarProgressBar.isVisible = true
            HomeProgressBar.STATUS -> ui.statusProgressBar.isVisible = true
        }
    }

    private fun hideProgressBar(progressBar: HomeProgressBar) {
        when (progressBar) {
            HomeProgressBar.WEATHER -> ui.weatherProgressBar.isVisible = false
            HomeProgressBar.MICROCLIMATE -> ui.microclimateProgressBar.isVisible = false
            HomeProgressBar.CALENDAR -> ui.calendarProgressBar.isVisible = false
            HomeProgressBar.STATUS -> ui.statusProgressBar.isVisible = false
        }
    }

    private fun hideAllProgressBar() {
        ui.weatherProgressBar.isVisible = false
        ui.microclimateProgressBar.isVisible = false
        ui.calendarProgressBar.isVisible = false
        ui.statusProgressBar.isVisible = false
    }

}