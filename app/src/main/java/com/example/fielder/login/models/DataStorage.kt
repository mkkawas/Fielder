package com.example.fielder.login.models

object DataStorage {

    lateinit var fname:String
    lateinit var sname:String
    lateinit var phonenb:String
    lateinit var email:String
    lateinit var fields: List<Fields>

    fun reset(){
        fname = ""
        sname= ""
        phonenb = ""
        fields = listOf()
        email = ""
    }
}