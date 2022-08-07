package com.example.listofcocktail.presentation.cocktail_item

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.listofcocktail.R
import com.example.listofcocktail.databinding.FragmentCocktailItemBinding
import com.example.listofcocktail.domain.model.CocktailFullInfo
import com.example.listofcocktail.presentation.main.CocktailApp
import com.example.listofcocktail.presentation.main.ViewModelFactory
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_cocktail_layout.view.*
import java.lang.RuntimeException
import javax.inject.Inject


class CocktailItemFragment : Fragment() {

    private var _binding: FragmentCocktailItemBinding? = null
    private val binding: FragmentCocktailItemBinding
        get() = _binding ?: throw RuntimeException("FragmentCocktailItemBinding == null")

    private lateinit var targetId: String

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as CocktailApp).component
    }

    private val adapter by lazy {
        IngredientListAdapter()
    }

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[CocktailItemViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCocktailItemBinding.inflate(inflater, container, false)
        parsParam()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeState()
        viewModel.getCocktailFullInfo(targetId)
    }

    private fun observeState() {
        viewModel.state.observe(viewLifecycleOwner) {
            with(binding) {
                when (it) {
                    is LoadingState -> {
                        pbLoadCocktailInfo.visibility = View.VISIBLE
                        tvErrorGettingInfo.visibility = View.GONE
                        svCocktailInfo.visibility = View.GONE
                    }
                    is ErrorState -> {
                        pbLoadCocktailInfo.visibility = View.GONE
                        tvErrorGettingInfo.visibility = View.VISIBLE
                        svCocktailInfo.visibility = View.GONE
                        viewModel.getCocktailFullInfo(targetId)
                    }
                    is ReadyState -> {
                        pbLoadCocktailInfo.visibility = View.GONE
                        tvErrorGettingInfo.visibility = View.GONE
                        svCocktailInfo.visibility = View.VISIBLE
                        showInformation(it.cocktailFullInfo)
                    }
                }
            }
        }
    }

    private fun showInformation(cocktailFullInfo: CocktailFullInfo) {
        with(binding) {
            tvCocktailName.text = cocktailFullInfo.name
            tvCocktailCategory.text = viewModel.getCategory(cocktailFullInfo)
            tvCocktailGlass.text = cocktailFullInfo.glass
            tvCocktailInstruction.text = cocktailFullInfo.instruction

            Picasso.with(context)
                .load(cocktailFullInfo.imageUrl)
                .placeholder(R.drawable.ic_cocktail_default)
                .error(R.drawable.ic_cocktail_default)
                .into(ivCocktailImage)

            rvIngredientList.adapter = adapter
            adapter.ingredientList = cocktailFullInfo.ingredients
        }
    }

    private fun parsParam() {
        targetId = requireArguments().getString(EXTRA_ID) ?: throw RuntimeException("Undefined id")
    }

    companion object {
        private const val EXTRA_ID = "id_extra"

        fun newInstance(id: String) = CocktailItemFragment().apply {
            arguments = Bundle().apply {
                putString(EXTRA_ID, id)
            }
        }
    }
}