package com.example.sharedviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.sharedviewmodel.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!
    private val viewModel : SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = Fragment1Binding.inflate(inflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller= FilterFragmentEpoxyController1(viewModel)

        binding.epoxyRecyclerView.setController(controller)

        viewModel._filterByGenreInfo1LiveData.observe(viewLifecycleOwner){setOfGenresFilter->

            val genreData = setOfGenresFilter.genres.map { genres ->
                UiGenreFilter(
                    filterDisplayName = genres,
                    isSelected = setOfGenresFilter.selectedGenres.contains(genres)
                )
            }

            controller.setData(genreData)

        }




        binding.btn.setOnClickListener {
            findNavController().navigate(Fragment1Directions.actionFragment1ToFragment2())
        }



        }



}