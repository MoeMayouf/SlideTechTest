package com.test.sliidetest.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.sliidetest.R
import com.test.sliidetest.common.App
import com.test.sliidetest.common.dagger.activity.ActivityComponent
import com.test.sliidetest.common.dagger.activity.ActivityComponentHolder
import com.test.sliidetest.common.dagger.activity.DaggerActivityComponent
import com.test.sliidetest.data.model.SlideModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainPresenter.MainView, ActivityComponentHolder {

    override val component: ActivityComponent by lazy {
        DaggerActivityComponent.builder()
            .sessionComponent((applicationContext as App).currentSession())
            .build()
    }

    @Inject
    lateinit var mainPresenter: MainPresenter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: MainAdapter

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun showName(name: SlideModel) {
        progressBar.visibility = View.GONE

        adapter = MainAdapter(name, applicationContext)
        recyclerView.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager


        component.inject(this)
        mainPresenter.onViewAttached(this)
    }

    override fun onPause() {
        super.onPause()
        mainPresenter.onViewDetached()
    }
}
