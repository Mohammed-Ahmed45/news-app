package Categories

import Adabter.CategoriesAdabter
import Base.BaseFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mohamed.news_app.R
import com.mohamed.news_app.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment()
{
    lateinit var binding:FragmentCategoriesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        binding=FragmentCategoriesBinding.inflate(layoutInflater,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }


    private fun initView()
    {
        val category=Category.getCategory()
        val Adabter=CategoriesAdabter(category)

        binding.rvCategories.adapter=Adabter
        Adabter.onItemClickListener= CategoriesAdabter.OnItemClickListener {
        position, category ->
            navigateToNews(category)
        }
    }

    private fun navigateToNews(category: Category)
    {
       val direction=CategoriesFragmentDirections.actionCategroriesFragmentToNewsFragment(category)
        findNavController()
            .navigate(direction)

    }


}