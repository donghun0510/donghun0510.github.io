package com.acaroom.coupon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var retrofit = Retrofit.Builder()
            .baseUrl("http//172...port number")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val loginService: LoginService = retrofit.create(LoginService::class.java)

        btn_find.setOnClickListener() { // Find client's ID/PW
            val intent = Intent(this, FindActivity::class.java)
            startActivity(intent)
        }
        btn_join.setOnClickListener() { // Join in APP
            val intent = Intent(this, JoinActivity::class.java)
            startActivity(intent)
        }
        btn_login.setOnClickListener() { // If success in login, intent next page
            val inputID = input_id.text.toString()
            val inputPW = input_pw.text.toString()

            loginService.requestLogin(inputID,inputPW).enqueue(object: Callback<Login>{
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    Toast.makeText(this@LoginActivity,"로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()
                    startActivity(intent)

                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    Toast.makeText(this@LoginActivity,"로그인에 실패하였습니다.", Toast.LENGTH_SHORT).show()
                }

            })

        }
    }
}