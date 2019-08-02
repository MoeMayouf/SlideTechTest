package com.test.sliidetest.common.dagger.activity

import com.test.sliidetest.common.dagger.session.SessionComponent
import com.test.sliidetest.presentation.MainActivity
import dagger.Component

@Component(dependencies = [SessionComponent::class])
@ActivityScope
interface ActivityComponent : SessionComponent {
    fun inject(target: MainActivity)
}