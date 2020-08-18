package com.acaroom.helloandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val tvTitle = findViewById<TextView>(R.id.tv_title)
        //tvTitle.text = "Hello Kotlin"

        tv_title.text = "Hello Kotlin! again!~"

        titleOn()
    }
}

fun MainActivity.titleOn() {
    tv_title.text = "Hi There!"
    tv_title.visibility = View.VISIBLE
}
