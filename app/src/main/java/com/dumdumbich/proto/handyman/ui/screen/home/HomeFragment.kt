package com.dumdumbich.proto.handyman.ui.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dumdumbich.proto.handyman.R
import com.dumdumbich.proto.handyman.databinding.FragmentHomeBinding
import com.dumdumbich.proto.handyman.ui.base.BaseFragment
import com.dumdumbich.proto.handyman.ui.base.BaseFragmentFactory
import com.dumdumbich.proto.handyman.ui.base.BaseViewPagerAdapter
import com.dumdumbich.proto.handyman.ui.screen.home.info.HomeInfoFragment
import com.dumdumbich.proto.handyman.ui.screen.home.room.ante.AnteRoomFragment
import com.dumdumbich.proto.handyman.ui.screen.home.room.bath.BathRoomFragment
import com.dumdumbich.proto.handyman.ui.screen.home.room.bed.BedRoomFragment
import com.dumdumbich.proto.handyman.ui.screen.home.room.living.LivingRoomFragment
import com.google.android.material.tabs.TabLayoutMediator


class HomeFragment : BaseFragment() {

    private var _ui: FragmentHomeBinding? = null
    private val ui get() = _ui!!

    private val fragments = listOf(
        BaseFragmentFactory("", R.drawable.ic_baseline_info) { HomeInfoFragment() },
        BaseFragmentFactory("", R.drawable.ic_baseline_input) { AnteRoomFragment() },
        BaseFragmentFactory("", R.drawable.ic_baseline_living) { LivingRoomFragment() },
        BaseFragmentFactory("", R.drawable.ic_baseline_bedroom_parent) { BedRoomFragment() },
        BaseFragmentFactory("", R.drawable.ic_baseline_bathroom) { BathRoomFragment() },
    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentHomeBinding.inflate(inflater, container, false).root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _ui = FragmentHomeBinding.bind(view)

        ui.homeViewPager.adapter = BaseViewPagerAdapter(this, fragments)

        TabLayoutMediator(ui.homeTabLayout, ui.homeViewPager) { tab, position ->
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