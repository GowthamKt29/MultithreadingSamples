package com.example.androidmultithreadingsample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val arrData = arrayListOf(
        LocalData("Example 1"),
        LocalData("Example 2"),
        LocalData("Example 3"),
        LocalData("Example 4")
    )
    val localData: (LocalData) -> Unit = { localData ->
        toast(message = "You clicked mama ${localData.name}")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }

    fun Context.toast(
        context: Context = applicationContext,
        message: String,
        toastDuration: Int = Toast.LENGTH_SHORT
    ) {
        Toast.makeText(context, message, toastDuration).show()
    }

    fun Context.stringResToast(
        context: Context = applicationContext,
        message: Int,
        toastDuration: Int = Toast.LENGTH_SHORT
    ) {
        Toast.makeText(context, context.getString(message), toastDuration).show()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            adapter = MainAdapter(this@MainActivity, localData = arrData) {

                //                toast(message = "You clicked ${it}")
                when (it) {
                    0 -> startActivity(Intent(this@MainActivity, ExerciseOne::class.java))
                    1 -> startActivity(Intent(this@MainActivity, ExerciseTwo::class.java))
                    else -> {
                    }
                }
            }

        }


    }

}
