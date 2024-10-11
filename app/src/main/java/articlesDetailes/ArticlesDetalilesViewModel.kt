package articlesDetailes


import Base.UIMessage
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import api.WebServices

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import model.Articles
import model.ArticlesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class ArticlesDetalilesViewModel @Inject constructor
    (
    savedStateHandle: SavedStateHandle,
    val webServices: WebServices
            ):ViewModel()

{
     val _article= MutableLiveData<Articles>()

    val article: LiveData<Articles> get() = _article

    private val _uiMessage = MutableLiveData<UIMessage>()
    val uiMessage: LiveData<UIMessage> get() = _uiMessage

    fun getArticle(title:String){
//        webServices.getArticle(searchIn = title)
//        uiMessage.postValue(UiMessage(showLodaing = true))
        viewModelScope.launch(Dispatchers.IO) {
            webServices.getArticle(title= title)
                .enqueue(object :Callback<ArticlesResponse>{
                    override fun onFailure(call: Call<ArticlesResponse>, ex: Throwable)
                    {

                        _uiMessage.postValue(
                            UIMessage(
                                isLoading = false,
                                errorMessage = ex.localizedMessage,
                                posAction = {
                                    getArticle(title)
                                })
                        )

                }

                    override fun onResponse(
                        call: Call<ArticlesResponse>,
                        response: Response<ArticlesResponse>
                    )
                    {
                        if (response.isSuccessful){
                            _article.postValue(response.body()?.articles?.get(0))

                        }
                        _uiMessage.postValue(
                            UIMessage(
                                isLoading = false,
                                shouldDisplayNoArticlesFound = response.body()?.articles!!.isEmpty(),
                                posAction = {
                                    getArticle(title)
                                }
                            )
                        )

                    }

                    })

        }

    }

}