package api

import model.ArticlesResponse
import model.SourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WebServices
{
    @GET ("/v2/top-headlines/sources")
    fun getNewsSources(
        @Query ("apiKey") authKey:String= "397c92fdf44e4c14aaa358ea0e255765"
        ,@Query ("category") category:String
    ):Call<SourcesResponse>

    @GET ("/v2/everything")

    fun getArticlesSources(
        @Query ("apiKey") authKey:String= "397c92fdf44e4c14aaa358ea0e255765"
       , @Query ("sources") sources:String
    ):Call<ArticlesResponse>

    @GET ("/v2/everything")
    fun getArticle(
        @Query ("apiKey") authKey:String= "397c92fdf44e4c14aaa358ea0e255765"
       ,@Query("q") title: String?=null,
        @Query ("searchIn") searchIn :String ="title"
    ):Call<ArticlesResponse>
}