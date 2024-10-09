package api

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiManager
{
    //get retrofit to run api
     var retrofit: Retrofit? =null


    @Provides
    @Singleton
     fun provideRetrofit(okHttpClient: OkHttpClient,
                                gsonConverterFactory: GsonConverterFactory): Retrofit
    {
        if (retrofit==null){
            //build retrofite
            retrofit=Retrofit.Builder()
                .baseUrl("https://newsapi.org")
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .build()
        }
        return retrofit!!
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory():GsonConverterFactory{
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
     fun provideOkHttpClient(
        provideLoggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(provideLoggingInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor
    {
        val loggingInterceptor = HttpLoggingInterceptor {
            Log.e("api" , it)
        }
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return loggingInterceptor
    }



    @Provides
    @Singleton
    fun getServices(retrofit: Retrofit):WebServices{
        return retrofit.create(WebServices::class.java)
    }

}