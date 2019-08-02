package com.test.sliidetest.domain

import android.util.Log
import com.test.sliidetest.data.model.SlideModel
import com.test.sliidetest.data.service.ApiManagerImpl
import io.reactivex.Observable
import javax.inject.Inject

class NewsRepo @Inject constructor(private val apiManagerImpl: ApiManagerImpl) {
    fun execute(): Observable<SlideModel> {
        Log.d("CALL2", "WORKING")
        return apiManagerImpl.getSliideNews()
    }
}