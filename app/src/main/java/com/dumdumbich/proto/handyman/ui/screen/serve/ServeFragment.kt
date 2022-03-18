package com.dumdumbich.proto.handyman.ui.screen.serve

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import com.dumdumbich.proto.handyman.R
import com.dumdumbich.proto.handyman.databinding.FragmentServeBinding
import com.dumdumbich.proto.handyman.ui.base.BaseFragment
import com.dumdumbich.proto.handyman.ui.base.BaseFragmentFactory
import com.dumdumbich.proto.handyman.ui.base.BaseViewPagerAdapter
import com.dumdumbich.proto.handyman.ui.screen.serve.console.ConsoleServeFragment
import com.dumdumbich.proto.handyman.ui.screen.serve.setting.SettingServeFragment
import com.google.android.material.tabs.TabLayoutMediator


class ServeFragment : BaseFragment() {

    private var _ui: FragmentServeBinding? = null
    private val ui get() = _ui!!

    private val fragments = listOf(
        BaseFragmentFactory("", R.drawable.ic_baseline_terminal) { ConsoleServeFragment() },
        BaseFragmentFactory("", R.drawable.ic_baseline_settings) { SettingServeFragment() },
    )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentServeBinding.inflate(inflater, container, false).root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _ui = FragmentServeBinding.bind(view)

        ui.serveViewPager.adapter = BaseViewPagerAdapter(this, fragments)

        TabLayoutMediator(ui.serveTabLayout, ui.serveViewPager) { tab, position ->
            fragments[position].let { factory ->
                tab.icon = AppCompatResources.getDrawable(requireContext(),factory.iconResId)
            }
        }.attach()
    }

    override fun onDestroyView() {
        _ui = null
        super.onDestroyView()
    }

}