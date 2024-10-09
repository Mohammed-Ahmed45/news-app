package articlesDetailes

import Base.BaseFragment
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.mohamed.news_app.MainActivity
import com.mohamed.news_app.R
import com.mohamed.news_app.databinding.FragmentArticlesDetailesBinding
import dagger.hilt.android.AndroidEntryPoint
import model.Articles

@AndroidEntryPoint
class ArticlesDetailesFragment :BaseFragment<FragmentArticlesDetailesBinding>()
{

    override fun getLayoutId(): Int=   R.layout.fragment_articles_detailes

    private val viewModel by viewModels<ArticlesDetalilesViewModel>()
    private val args by navArgs<ArticlesDetailesFragmentArgs>()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getArticle(args.title)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        initObservers()

    }

    private fun initObservers() {
        viewModel.article.observe(viewLifecycleOwner){article->
            binding.articleReadMore.text=getString(R.string.view_full_article)
            onViewFullArticleClick(article)

        }
    }

    private fun onViewFullArticleClick(article: Articles) {
        binding.articleReadMore.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(article.url)
            startActivity(intent)
        }

    }

}
