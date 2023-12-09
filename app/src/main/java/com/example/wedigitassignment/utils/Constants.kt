package com.example.wedigitassignment.utils

import com.example.wedigitassignment.R

object Constants {
    fun getUserJamsList(): List<ProfileJamsModel> {

        val dataList = mutableListOf<ProfileJamsModel>()

        dataList.add(ProfileJamsModel(R.drawable.jam_img_1, "84.5K"))
        dataList.add(ProfileJamsModel(R.drawable.jam_img_2, "84.5K"))
        dataList.add(ProfileJamsModel(R.drawable.jam_img_3, "84.5K"))
        dataList.add(ProfileJamsModel(R.drawable.jam_img_4, "84.5K"))
        dataList.add(ProfileJamsModel(R.drawable.jam_img_1, "84.5K"))
        dataList.add(ProfileJamsModel(R.drawable.jam_img_2, "84.5K"))
        dataList.add(ProfileJamsModel(R.drawable.jam_img_3, "84.5K"))
        dataList.add(ProfileJamsModel(R.drawable.jam_img_4, "84.5K"))
        dataList.add(ProfileJamsModel(R.drawable.jam_img_1, "84.5K"))
        dataList.add(ProfileJamsModel(R.drawable.jam_img_2, "84.5K"))
        dataList.add(ProfileJamsModel(R.drawable.jam_img_3, "84.5K"))
        dataList.add(ProfileJamsModel(R.drawable.jam_img_4, "84.5K"))
        dataList.add(ProfileJamsModel(R.drawable.jam_img_2, "84.5K"))
        dataList.add(ProfileJamsModel(R.drawable.jam_img_4, "84.5K"))

        return dataList
    }

    fun getUserProfileDetails(): UserProfile {

        return UserProfile(
            "@arlenecoy",
            R.drawable.avatar,
            "Arlene McCoy",
            "Lorem ipsum dolor sit amet, consectetur Lorem ipsum dolor sit amet, consectetur lorem",
            9.9,
            84.5,
            32,
            231
        )

    }
}