package com.example.fielder.login.homepage

import com.example.fielder.login.models.Field

class mockSource {

    companion object{
        fun createDataSet(): ArrayList<Field>{
            val list = ArrayList<Field>()
            list.add(
                Field(
                    "koosa",
                    "football",
                    "out door",
                    "5x5",
                    "71727171",
                    "maps.google.com",
                    "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/digital_ocean.png",
                )
            )
            list.add(
                Field(
                    "koosa",
                    "football",
                    "out door",
                    "5x5",
                    "71727171",
                    "maps.google.com",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/time_to_build_a_kotlin_app.png"
                )
            )
            list.add(
                Field(
                    "koosa",
                    "football",
                    "out door",
                    "5x5",
                    "71727171",
                    "maps.google.com",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/coding_for_entrepreneurs.png"
                )
            )
            list.add(
                Field(
                    "koosa",
                    "football",
                    "out door",
                    "5x5",
                    "71727171",
                    "maps.google.com",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/freelance_android_dev_vasiliy_zukanov.png"
                )
            )
            list.add(
                Field(
                    "koosa",
                    "football",
                    "out door",
                    "5x5",
                    "71727171",
                    "maps.google.com",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/freelance_android_dev_donn_felker.png"
                )
            )
            return list
        }
    }
}