package com.example.listofcocktail.presentation.cocktail_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.listofcocktail.databinding.FragmentCocktailListBinding
import java.lang.RuntimeException

class CocktailListFragment : Fragment() {

    private var _binding: FragmentCocktailListBinding? = null
    private val binding: FragmentCocktailListBinding
        get() = _binding ?: throw RuntimeException("FragmentCocktailListBinding == null")

    private val viewModel by lazy {
        ViewModelProvider(this)[CocktailListViewModel::class.java]
    }

    private val adapter by lazy {
        CocktailListAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCocktailListBinding
            .inflate(layoutInflater, container, false)
        binding.rvCocktailList.adapter = adapter
        observeViewModel()
        viewModel.setCocktailList()
        return binding.root
    }

    private fun observeViewModel() {
        viewModel.drinkList.observe(viewLifecycleOwner) {
            with(binding) {
                when (it) {
                    is LoadingState -> {
                        pbLoadCocktailList.visibility = View.VISIBLE
                        tvErrorGettingList.visibility = View.GONE
                        rvCocktailList.visibility = View.GONE
                    }
                    is ErrorState -> {
                        pbLoadCocktailList.visibility = View.GONE
                        tvErrorGettingList.visibility = View.VISIBLE
                        rvCocktailList.visibility = View.GONE
                        viewModel.setCocktailList()
                    }
                    is ReadyState -> {
                        pbLoadCocktailList.visibility = View.GONE
                        tvErrorGettingList.visibility = View.GONE
                        rvCocktailList.visibility = View.VISIBLE
                        adapter.setCocktailsList(it.cocktailList)
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun getInstance() = CocktailListFragment()
    }
}