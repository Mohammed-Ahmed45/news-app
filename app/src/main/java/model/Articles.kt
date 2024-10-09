package model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
 class Articles(



	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("urlToImage")
	val urlToImage: String? = null,

	@field:SerializedName("content")
	val content: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("source")
	val source:NewsSources? = null,


	@field:SerializedName("publishedAt")
	val publishedAt: String? = null,

	@field:SerializedName("url")
	val url: String? = null,


) : Parcelable