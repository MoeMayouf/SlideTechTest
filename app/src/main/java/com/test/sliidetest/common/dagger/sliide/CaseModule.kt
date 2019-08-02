package com.test.sliidetest.common.dagger.sliide

import com.busuu.interviewtest.common.dagger.cases.CaseQualifier
import com.busuu.interviewtest.common.dagger.cases.SessionScope
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.test.sliidetest.common.Constants
import com.test.sliidetest.data.service.ApiManager
import com.test.sliidetest.data.service.ApiManagerImpl
import com.test.sliidetest.data.service.ServiceApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class CaseModule {

    @Provides
    @SessionScope
    @CaseQualifier
    fun okClient(okHttpClientBuilder: OkHttpClient.Builder): OkHttpClient {
        return okHttpClientBuilder
            .build()
    }

    @Provides
    @SessionScope
    fun loyaltyService(
        @CaseQualifier okClient: OkHttpClient,
        gson: Gson
    ): ServiceApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .client(okClient)
            .build()
            .create(ServiceApi::class.java)
    }

    @Provides
    @SessionScope
    fun loyaltyApi(
        restService: ServiceApi
    ): ApiManager = ApiManagerImpl(restService)
}