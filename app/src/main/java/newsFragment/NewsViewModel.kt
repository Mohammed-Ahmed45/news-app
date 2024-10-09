package newsFragment

import Base.UiMessage
import Categories.Category
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import api.WebServices
import com.mohamed.news_app.R
import dagger.hilt.android.lifecycle.HiltViewModel
import model.Articles
import model.ArticlesResponse
import model.NewsSources
import model.SourcesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val webServices: WebServices
): ViewModel()
{
    private val categoryParam="category"
    val uiMessage=MutableLiveData<UiMessage>()
    val sourceLiveData=MutableLiveData<List<NewsSources?>?>()
    val articleLiveData=MutableLiveData<List<Articles?>?>()
    private val category:Category? = savedStateHandle[categoryParam]

    fun searchArticles(query: String?): List<Articles?>?  {
        return articleLiveData.value?.filter { product ->
            product?.title?.contains(query.toString(), ignoreCase = true) == true ||
                    product?.author?.contains(query.toString(), ignoreCase = true) == true ||
                    product?.content?.contains(query.toString(), ignoreCase = true) == true
        }?.toList()


    }

    fun getNewsSources()
    {
        uiMessage.value=UiMessage(
            showLodaing = true,
            messageId = R.string.lodaing
        )

        // 1->get api of NewsSource
        webServices
            .getNewsSources(category= category?.id ?:"")
            .enqueue(object : Callback<SourcesResponse>
            {
                override fun onFailure(call: Call<SourcesResponse>, ex: Throwable)
                {
                    uiMessage.value=UiMessage(
                        showLodaing = false,
                        exeption = ex,
                        onPosClick = {
                            getNewsSources()
                        }
                    )
                }

                override fun onResponse(call: Call<SourcesResponse>, response: Response<SourcesResponse>)
                {
                    if (response.isSuccessful){
                    sourceLiveData.value=response.body()?.sources

                    }



                }
            })






    }
    fun getNews(id: String)
    {
        webServices
            .getArticlesSources(sources = id )
            .enqueue(object :Callback<ArticlesResponse>{
                override fun onFailure(call: Call<ArticlesResponse>, ex: Throwable)
                {
                    uiMessage.value=UiMessage(
                        showLodaing = false,
                        exeption = ex,
                        onPosClick ={
                            getNewsSources()
                        }

                    )
                }

                override fun onResponse(call: Call<ArticlesResponse>, response: Response<ArticlesResponse>)
                {
                    uiMessage.value=UiMessage(
                        showLodaing = false

                    )
                    if (response.isSuccessful){
                        articleLiveData.value=response.body()?.articles
                    }

                }
            })
    }

}