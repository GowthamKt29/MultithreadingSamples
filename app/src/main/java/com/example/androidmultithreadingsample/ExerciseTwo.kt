package com.example.androidmultithreadingsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_exercise.*
import java.util.concurrent.atomic.AtomicBoolean

class ExerciseTwo : AppCompatActivity() {
    private val ITERATIONS_COUNTER_DURATION_SEC = 10
    private val mCountAbort =
        AtomicBoolean(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        btn.setOnClickListener {
            Thread(Runnable {
                countIteration()
            }).start()

        }
    }

    override fun onStop() {
        super.onStop()
        mCountAbort.set(true)
    }

    private fun countIteration() {
        mCountAbort.set(false)
        var screenTimeSeconds = 0
        while (true) {
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {
                return
            }
            if (mCountAbort.get()) return
            screenTimeSeconds++
            Log.d("Exercise 2", "screen time: " + screenTimeSeconds + "s")
        }
    }
}