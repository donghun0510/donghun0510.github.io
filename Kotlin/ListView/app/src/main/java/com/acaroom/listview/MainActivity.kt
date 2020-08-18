package com.acaroom.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var dogList = arrayList<Dog>(
        Dog("Chow Chow", "Male", "4", "dog00"),
        Dog("Breed Pomeranian", "Female", "1", "dog01"),
        Dog("Golden Retriver", "Female", "3", "dog02"),
        Dog("Yorkshire Terrier", "Male", "5", "dog03"),
        Dog("Pug", "Male", "4", "dog04"),
        Dog("Alaskan Malamute", "Male", "7", "dog05"),
        Dog("Shih Tzu", "Female", "5", "dog06")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dogAdapter = MainListAdapter(this, dogList)
        mainListView.adapter = dogAdapter
    }
}
