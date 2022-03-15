package com.dumdumbich.proto.handyman.ui.pages.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dumdumbich.proto.handyman.databinding.FragmentSettingBinding
import com.dumdumbich.proto.handyman.ui.base.BaseFragment


class SettingFragment : BaseFragment() {

    private var _ui: FragmentSettingBinding? = null
    private val ui get() = _ui!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSettingBinding.inflate(inflater, container, false).root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _ui = FragmentSettingBinding.bind(view)
    }

    override fun onDestroyView() {
        _ui = null
        super.onDestroyView()
    }

}