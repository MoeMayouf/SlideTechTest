package com.test.sliidetest.common

import android.app.Application
import com.test.sliidetest.common.dagger.AppComponent
import com.test.sliidetest.common.dagger.AppModule
import com.test.sliidetest.common.dagger.DaggerAppComponent
import com.test.sliidetest.common.dagger.session.DaggerSessionComponent
import com.test.sliidetest.common.dagger.session.SessionComponent

class App : Application() {
    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    private lateinit var sessionComponent: SessionComponent

    override fun onCreate() {
        super.onCreate()
        resetSession()
        //currentSession()
    }

    fun currentSession(): SessionComponent {
        return sessionComponent
    }

    fun resetSession() {

        sessionComponent = DaggerSessionComponent.builder()
            .appComponent(appComponent)
            .build()

    }
}