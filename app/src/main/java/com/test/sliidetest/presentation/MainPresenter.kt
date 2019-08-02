package com.test.sliidetest.presentation

import android.util.Log
import com.test.sliidetest.data.model.SlideModel
import com.test.sliidetest.domain.NewsRepo
import com.test.sliidetest.presentation.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(private val newsRepo: NewsRepo) :
    BasePresenter<MainPresenter.MainView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onViewAttached(view: MainView) {
        super.onViewAttached(view)
        view.showLoading()

        compositeDisposable.add(
            newsRepo.execute()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ results ->
                    Log.d("CALL3", "WORKING")
                    view.showItems(results)
                },
                    { throwable ->
                        Log.d("Error", throwable.message)
                    })
        )
    }

    interface MainView : BasePresenter.View {

        fun showLoading()
        fun showItems(name: SlideModel)

    }
}