package com.dumdumbich.proto.handyman.ui.screen.scheduler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dumdumbich.proto.handyman.databinding.FragmentSchedulerBinding
import com.dumdumbich.proto.handyman.ui.base.BaseFragment


class SchedulerFragment : BaseFragment() {

    private var _ui: FragmentSchedulerBinding? = null
    private val ui get() = _ui!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSchedulerBinding.inflate(inflater, container, false).root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _ui = FragmentSchedulerBinding.bind(view)
    }

    override fun onDestroyView() {
        _ui = null
        super.onDestroyView()
    }

}