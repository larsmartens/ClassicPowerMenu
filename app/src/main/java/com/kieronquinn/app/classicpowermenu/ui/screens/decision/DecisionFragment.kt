package com.kieronquinn.app.classicpowermenu.ui.screens.decision

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kieronquinn.app.classicpowermenu.ui.activities.MainActivityViewModel
import com.kieronquinn.app.classicpowermenu.utils.extensions.whenResumed
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DecisionFragment: Fragment() {

    private val viewModel by viewModel<DecisionViewModel>()
    private val appViewModel by activityViewModel<MainActivityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setupAppReady()
        return View(context)
    }

    private fun setupAppReady() = whenResumed {
        viewModel.decisionMade.collect {
            appViewModel.onDecisionMade()
        }
    }

}