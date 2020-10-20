package com.acaroom.coupon

import android.util.Log

data class MyModel(var name: String? = null, var profileImage: String? = null) {

    val TAG: String = "Log"

    // 기본 생성자
    init {
        Log.d(TAG, "MyModel - init() called")
    }
}