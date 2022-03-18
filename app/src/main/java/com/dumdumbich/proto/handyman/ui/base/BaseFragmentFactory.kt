package com.dumdumbich.proto.handyman.ui.base

import androidx.fragment.app.Fragment
import com.dumdumbich.proto.handyman.R


data class BaseFragmentFactory(
    val title: String = "",
    val iconResId: Int = R.drawable.ic_baseline_factory,
    val factoryCall: () -> Fragment
)