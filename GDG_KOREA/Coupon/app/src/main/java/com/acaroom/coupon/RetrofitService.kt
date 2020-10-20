package com.acaroom.coupon

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

//input & service

interface LoginService {
    @FormUrlEncoded
    @POST("/login/")
    fun requestLogin(
        @Field("ID") ID: String,
        @Field("PW") PW:String
    ) : Call<Login>
}
interface JoinService {
    @FormUrlEncoded
    @POST("/join/")
    fun requestJoin(
        @Field("ID") ID: String,
        @Field("PW") PW:String,
        @Field("NickName") NickName: String,
        @Field("Hint") Hint:String
    ) : Call<Joining>
}
interface FindIDService {
    @FormUrlEncoded
    @POST("/login/")
    fun requestLogin(
        @Field("NickName") NickName: String
    ) : Call<FindingID>
}
interface FindPWService {
    @FormUrlEncoded
    @POST("/login/")
    fun requestLogin(
        @Field("ID") ID: String,
        @Field("PW") PW:String
    ) : Call<FindingPW>
}