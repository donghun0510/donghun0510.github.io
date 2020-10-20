package com.acaroom.coupon

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){

    val TAG: String = "로그"

    // for data
    var modelList = ArrayList<MyModel>()

    private lateinit var myRecyclerAdapter: MyRecyclerAdapter

    // View on screen
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")
        // Log.d(TAG, "MainActivity - 반복문 전 this.modelList.size : ${this.modelList.size}")


        for(i in 1..10){
            val myModel = MyModel(name = "Cafe $i", profileImage = "")
            this.modelList.add(myModel)
        }

        // Log.d(TAG, "MainActivity - 반복문 후 this.modelList.size : ${this.modelList.size}")

        // Adapter instance Create
        myRecyclerAdapter = MyRecyclerAdapter()

        myRecyclerAdapter.submitList(this.modelList)

        // RecyclerView Setting
        recycler_view.apply {
            // Recycler direction ..etc setting
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            // Adapter mount
            adapter = myRecyclerAdapter
        }

        btn_QR.setOnClickListener{
            val intent = Intent(this@MainActivity, ScanQR::class.java)
            startActivity(intent)
        }
    }
}