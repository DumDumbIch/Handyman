package com.dumdumbich.proto.handyman.ui.base

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class BaseViewPagerAdapter(
    fragment: Fragment,
    private val fragments: List<BaseFragmentFactory>
) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position].factoryCall()

}