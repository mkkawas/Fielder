package com.example.fielder.login.services

import com.example.fielder.login.models.Fields
import com.example.fielder.login.models.LogInModel
import com.example.fielder.login.models.RegisterModel

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
}