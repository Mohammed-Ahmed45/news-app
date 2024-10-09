package Adabter

import Base.BaseAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mohamed.news_app.databinding.ItemNewsBinding
import model.Articles

class NewsAdabter: BaseAdapter<Articles, ItemNewsBinding>()
{

    override fun getBinding(parent: ViewGroup, viewType: Int): ItemNewsBinding
    =ItemNewsBinding.inflate(LayoutInflater.from(parent.context),parent,false)

    override fun bindData(binding: ItemNewsBinding, news: Articles, position: Int)
    {


        binding.root.setOnClickListener {
            onItemClick?.onClick(news,position)
        }
        Glide.with(binding.root)
            .load(news.urlToImage)
            .centerCrop()
            .into(binding.image)

       binding.title.text = news.title
        binding.author.text=news.author
        binding.date.text=news.publishedAt
    }

    var onItemClick:OnItemClickListener? = null

    fun interface OnItemClickListener{
        fun onClick(article: Articles,position: Int)
    }




}