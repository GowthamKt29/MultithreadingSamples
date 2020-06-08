package com.example.androidmultithreadingsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_exercise.*

class ExerciseOne : AppCompatActivity() {
    private val ITERATIONS_COUNTER_DURATION_SEC = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
        btn.setOnClickListener {
            Thread(Runnable {
                countIteration()
            }).start()

        }
    }

    private fun countIteration() {

        val startTime = System.currentTimeMillis()
        val endTime = startTime + ITERATIONS_COUNTER_DURATION_SEC * 1000
        var count = 0

        while (System.currentTimeMillis() <= endTime) count++

        Log.d(
            "Exercise1", "iterations in " + ITERATIONS_COUNTER_DURATION_SEC + "seconds: " + count
        )
    }
}