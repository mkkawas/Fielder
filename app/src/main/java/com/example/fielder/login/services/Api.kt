package com.example.fielder.login.services

import android.text.Editable
import com.example.fielder.login.models.*

import retrofit2.Call
import retrofit2.http.*

interface Api {
    @FormUrlEncoded
    @POST("registerUserNew.php")
    fun createUser(
        @Field("Fname") fname:String,
        @Field("Sname")sname:String,
        @Field("email")email:String,
        @Field("password")password:String,
        @Field("phoneNb")phonenb:String
    ): Call<RegisterModel>


    @GET("logIn.php")
    fun logIn(
        @Query("email")email:String,
        @Query("password")password:String
    ):Call<LogInModel>

    @GET("getFields.php")
    fun getFields(): Call<List<Fields>>

    @GET("search.php")
    fun search(
        @Query("sport")sport:String,
        @Query("city")city:String
    ): Call<List<Fields>>

    @FormUrlEncoded
    @POST("sendFeedback.php")
    fun sendFeedback(
        @Field("message") message: Editable,
        @Field("fullname") fullname:String
    ): Call<FeedbackModel>


    @FormUrlEncoded
    @POST("changePassword.php")
    fun changePass(
        @Field("email")email:String,
        @Field("oldpassword")oldpassword:String,
        @Field("newpassword")newpassword:String
    ): Call<ChangePassModel>

    @FormUrlEncoded
    @POST("changePhone.php")
    fun changePhone(
        @Field("email")email:String,
        @Field("oldphone")oldphone:String,
        @Field("newphone")newphone:String
    ): Call<ChangePassModel>
}