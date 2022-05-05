package com.example.fielder.login.homepage

import com.example.fielder.login.models.Fields

class mockSource {

    companion object{
        fun createDataSet(): ArrayList<Fields>{
            val list = ArrayList<Fields>()
            list.add(
                Fields(
                    "koosa",
                    "football",
                    "5x5",
                    "71727171",
                    "maps.google.com",
                    "beirut",
                    "https://raw.githubusercontent.com/mitchtabian/Blog-Images/master/digital_ocean.png",
                )
            )
            list.add(
                Fields(
                    "koosa",
                    "football",
                    "5x5",
                    "71727171",
                    "maps.google.com",
                    "beirut",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/time_to_build_a_kotlin_app.png"
                )
            )
            list.add(
                Fields(
                    "koosa",
                    "football",

                    "5x5",
                    "71727171",
                    "maps.google.com",
                    "beirut",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/coding_for_entrepreneurs.png"
                )
            )
            list.add(
                Fields(
                    "koosa",
                    "football",
                    "5x5",
                    "71727171",
                    "maps.google.com",
                    "beirut",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/freelance_android_dev_vasiliy_zukanov.png"
                )
            )
            list.add(
                Fields(
                    "koosa",
                    "football",
                    "5x5",
                    "71727171",
                    "maps.google.com",
                    "beirut",
                    "https://raw.githubusercontent.com/mitchtabian/Kotlin-RecyclerView-Example/json-data-source/app/src/main/res/drawable/freelance_android_dev_donn_felker.png"
                )
            )
            return list
        }
    }
}