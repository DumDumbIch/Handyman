package com.dumdumbich.proto.handyman.ui.screen.tune

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dumdumbich.proto.handyman.R
import com.dumdumbich.proto.handyman.databinding.FragmentTuneBinding
import com.dumdumbich.proto.handyman.ui.base.BaseFragment
import com.dumdumbich.proto.handyman.ui.base.BaseFragmentFactory
import com.dumdumbich.proto.handyman.ui.base.BaseViewPagerAdapter
import com.dumdumbich.proto.handyman.ui.screen.tune.page.auto.AutoTuneFragment
import com.dumdumbich.proto.handyman.ui.screen.tune.page.manual.ManualTuneFragment
import com.dumdumbich.proto.handyman.ui.screen.tune.page.schedule.ScheduleTuneFragment
import com.google.android.material.tabs.TabLayoutMediator


class TuneFragment : BaseFragment() {

    private var _ui: FragmentTuneBinding? = null
    private val ui get() = _ui!!

    private val fragments = listOf(
        BaseFragmentFactory("", R.drawable.ic_baseline_front_hand) { ManualTuneFragment() },
        BaseFragmentFactory("", R.drawable.ic_baseline_auto_mode) { AutoTuneFragment() },
        BaseFragmentFactory("", R.drawable.ic_baseline_schedule) { ScheduleTuneFragment() },
    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentTuneBinding.inflate(inflater, container, false).root

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _ui = FragmentTuneBinding.bind(view)

        ui.tuneViewPager.adapter = BaseViewPagerAdapter(this, fragments)

        TabLayoutMediator(ui.tuneTabLayout, ui.tuneViewPager) { tab, position ->
            fragments[position].let { factory ->
                tab.icon = resources.getDrawable(factory.iconResId)
            }
        }.attach()

    }

    override fun onDestroyView() {
        _ui = null
        super.onDestroyView()
    }

}