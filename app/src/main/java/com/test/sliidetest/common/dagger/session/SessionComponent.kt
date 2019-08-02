package com.test.sliidetest.common.dagger.session

import com.busuu.interviewtest.common.dagger.cases.SessionScope
import com.test.sliidetest.common.dagger.AppComponent
import com.test.sliidetest.common.dagger.CommonOkHttpClientBuilderModule
import com.test.sliidetest.common.dagger.sliide.CaseModule
import com.test.sliidetest.data.service.ApiManager
import com.test.sliidetest.data.service.ServiceApi
import dagger.Component

@Component(
    dependencies = [AppComponent::class],
    modules = [CaseModule::class, CommonOkHttpClientBuilderModule::class]
)
@SessionScope
interface SessionComponent : AppComponent {
    fun apiManager(): ApiManager
    fun iService(): ServiceApi

}