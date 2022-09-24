package com.example.sharedviewmodel

import com.example.sharedviewmodel.databinding.ModelFilterBinding

data class FilterEpoxyModel(
    val uiFilter: UiGenreFilter,
    val onFilterClick:(String) -> Unit
    )
    :ViewBindingKotlinModel<ModelFilterBinding>(R.layout.model_filter){
    override fun ModelFilterBinding.bind() {
        tvFilterName.text=uiFilter.filterDisplayName
        root.setOnClickListener { onFilterClick(uiFilter.filterDisplayName) }
        //checkbox.isClickable=false
        checkbox.isChecked = uiFilter.isSelected

    }

}
