package Adabter

import Categories.Category
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.news_app.databinding.ItemProductBinding

class CategoriesAdabter( val categories : List<Category>):RecyclerView.Adapter<CategoriesAdabter.ViewHolder>()
{
    class ViewHolder(var binding:ItemProductBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val binding=ItemProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return categories.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val item=categories[position]
        holder.binding.root.setCardBackgroundColor(item.BachgroundColor.toInt())
        holder.binding.imgCategory.setImageResource(item.imgId)
        holder.binding.title.text=item.title
        holder.binding.root.setOnClickListener{
            onItemClickListener?.OnClick(position,item)
            Log.e("id",item.id)
        }


    }

    var onItemClickListener:OnItemClickListener?=null
    fun interface OnItemClickListener{
        fun OnClick(position: Int,category: Category)
    }
}