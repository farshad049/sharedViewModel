package com.example.sharedviewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.airbnb.epoxy.TypedEpoxyController
import kotlinx.coroutines.launch

class FilterFragmentEpoxyController1(
    private val viewModel: SharedViewModel
): TypedEpoxyController<List<UiGenreFilter>>() {

    override fun buildModels(data1: List<UiGenreFilter>) {



        data1.forEach {
            FilterEpoxyModel(it, ::onGenreFilterClick1).id(it.filterDisplayName).addTo(this)
        }


    }




    private fun onGenreFilterClick1(selectedFilter : String){
        viewModel.viewModelScope.launch {
            val currentSelectedFilter = viewModel._filterByGenreInfo1LiveData.value!!

                val newFilter =  currentSelectedFilter.copy(
                    selectedGenres = if(currentSelectedFilter.selectedGenres.contains(selectedFilter)){
                        currentSelectedFilter.selectedGenres.filter { it != selectedFilter }.toSet()
                    }else{
                        currentSelectedFilter.selectedGenres + setOf(selectedFilter)
                    }
                )

                viewModel._filterByGenreInfo1LiveData.value = newFilter
            Log.i("filterrr" , newFilter.selectedGenres.toString())

        }
    }



}

