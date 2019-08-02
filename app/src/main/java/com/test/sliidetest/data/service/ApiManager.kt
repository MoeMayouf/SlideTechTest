package com.test.sliidetest.data.service

import com.test.sliidetest.data.model.SlideModel
import io.reactivex.Observable

interface ApiManager {

    fun getSliideNews(): Observable<SlideModel>
}