package com.cxyz.main;

import com.cxyz.utils.NetWorkUtil
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.TestScheduler
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.mockito.Mockito
import org.powermock.api.mockito.PowerMockito
import java.util.concurrent.TimeUnit

class AndroidRelativeRule : TestRule {

    private var testScheduler: TestScheduler = TestScheduler()

    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            @Throws(Throwable::class)
            override fun evaluate() {
                RxJavaPlugins.setIoSchedulerHandler { testScheduler }
                RxJavaPlugins.setComputationSchedulerHandler { testScheduler }
                RxJavaPlugins.setNewThreadSchedulerHandler { testScheduler }
                RxJavaPlugins.setSingleSchedulerHandler { testScheduler }
                RxAndroidPlugins.setInitMainThreadSchedulerHandler { testScheduler }
                netWork()
                try {
                    base?.evaluate()
                } finally {
                    RxJavaPlugins.reset()
                    RxAndroidPlugins.reset()
                }
            }
        }
    }

    private fun netWork() {
        PowerMockito.mockStatic(NetWorkUtil::class.java)
    }

    //advanceTimeTo()以绝对的方式调整时间
    fun advanceTimeTo(delayTime: Long, timeUnit: TimeUnit) {
        testScheduler.advanceTimeTo(delayTime, timeUnit)
    }

    //advanceTimeBy()方法将调度器的时间调整为相对于当前位置的时间
    fun advanceTimeBy(delayTime: Long, timeUnit: TimeUnit) {
        testScheduler.advanceTimeBy(delayTime, timeUnit)
    }

    fun getScheduler(): TestScheduler {
        return testScheduler
    }
}