package com.kieronquinn.app.classicpowermenu.ui.screens.powermenu.safemode

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import com.kieronquinn.app.classicpowermenu.R
import com.kieronquinn.app.classicpowermenu.databinding.FragmentTopsheetSafeModeBinding
import com.kieronquinn.app.classicpowermenu.ui.base.BaseTopSheetFragment
import com.kieronquinn.app.classicpowermenu.utils.extensions.onApplyInsets
import org.koin.androidx.viewmodel.ext.android.viewModel

class SafeModeTopSheetFragment: BaseTopSheetFragment<FragmentTopsheetSafeModeBinding>(FragmentTopsheetSafeModeBinding::inflate) {

    private val viewModel by viewModel<SafeModeTopSheetViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val accent = if(settings.useMonet){
            monet.getAccentColor(requireContext())
        }else{
            ContextCompat.getColor(requireContext(), R.color.accent)
        }
        with(binding.fragmentSafeModeTitle) {
            onApplyInsets { view, insets ->
                view.updatePadding(top = insets.getInsets(WindowInsetsCompat.Type.displayCutout()).top)
            }
        }
        with(binding.fragmentSafeModeOk){
            setTextColor(accent)
            setOnClickListener {
                viewModel.onRebootSafeModeClicked()
            }
        }
        with(binding.fragmentSafeModeCancel){
            setTextColor(accent)
            setOnClickListener {
                viewModel.onCancelClicked()
            }
        }
    }

}