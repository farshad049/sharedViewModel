package com.example.sharedviewmodel

import androidx.lifecycle.viewModelScope
import com.airbnb.epoxy.TypedEpoxyController
import kotlinx.coroutines.launch

class FilterFragmentEpoxyController2(
    private val viewModel: SharedViewModel
): TypedEpoxyController<List<UiGenreFilter>>() {

    override fun buildModels(data1: List<UiGenreFilter>) {



        data1.forEach {
            FilterEpoxyModel(it, ::onGenreFilterClick1).id(it.filterDisplayName).addTo(this)
        }


    }




    private fun onGenreFilterClick1(selectedFilter : String){

    }



}

