package com.example.listofcocktail.presentation.cocktail_list

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.listofcocktail.databinding.FragmentCocktailListBinding
import com.example.listofcocktail.presentation.main.CocktailApp
import com.example.listofcocktail.presentation.main.ViewModelFactory
import java.lang.RuntimeException
import javax.inject.Inject

class CocktailListFragment : Fragment() {

    private var _binding: FragmentCocktailListBinding? = null
    private val binding: FragmentCocktailListBinding
        get() = _binding ?: throw RuntimeException("FragmentCocktailListBinding == null")

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as CocktailApp).component
    }

    private val navigation by lazy {
        requireActivity() as Navigation
    }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CocktailListViewModel::class.java]
    }

    private val adapter by lazy {
        CocktailListAdapter()
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCocktailListBinding
            .inflate(layoutInflater, container, false)
        binding.rvCocktailList.adapter = adapter
        setClickListenerForAdapter()
        observeViewModel()
        viewModel.setCocktailList()
        return binding.root
    }

    private fun observeViewModel() {
        viewModel.state.observe(viewLifecycleOwner) {
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
                        adapter.cocktailList = it.cocktailList
                    }
                }
            }
        }
    }

    private fun setClickListenerForAdapter() {
        adapter.clickListener = {
            navigation.showCocktailInfo(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDetach() {
        super.onDetach()
        navigation.exit()
    }

    interface Navigation {
        fun showCocktailInfo(id: String)

        fun exit()
    }

    companion object {
        fun getInstance() = CocktailListFragment()
    }
}