package com.acaroom.coupon

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.Constraints.TAG
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter(): RecyclerView.Adapter<MyViewHolder>() {

    var TAG: String = "로그"

    private var modelList = ArrayList<MyModel>()

    // ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Setting for linking layout
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_item, parent, false))
    }
    //  When View and ViewHolder were bound
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG, "MyRecycler - onBindViewHolder() called / position: $position")
        holder.bind(this.modelList[position])
        // onClickListener can be set in here
    }
    // Items Count
    override fun getItemCount(): Int {
        return this.modelList.size
    }

    fun submitList(modelList: ArrayList<MyModel>){
        this.modelList = modelList
    }
}