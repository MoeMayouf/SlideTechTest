package com.test.sliidetest.data.service

import android.util.Log
import com.test.sliidetest.data.model.SlideModel
import io.reactivex.Observable
import javax.inject.Inject

class ApiManagerImpl @Inject constructor(private val serviceApi: ServiceApi) : ApiManager {
    override fun getSliideNews(): Observable<SlideModel> {
        Log.d("CALL", "WORKING")
        return serviceApi.getSliideNews(
            "t4QCg6zCkFrCW5CTJii52IAQojqNmyeJ",
            "Magazine_from_AppDevWebsite",
            "eccc7785-001c-4341-88f8-eddf15f3aa4a",
            "US",
            "en",
            "100",
            "0"
        )
    }

}