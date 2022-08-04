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
        binding.rcCocktailList.adapter = adapter
        viewModel.drinkList.observe(viewLifecycleOwner) { list ->
            list.body()?.let { adapter.setCocktailsList(it.drinks) }
        }
        viewModel.getDrinkList()
        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        fun getInstance() = CocktailListFragment()
    }
}