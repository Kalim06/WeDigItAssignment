package com.example.wedigitassignment.utils

class UserProfile(
    var userId: String,
    var userImage: Int,
    var userName: String,
    var userBio: String,
    var ratingCount: Double,
    var playCount: Double,
    var friendsCount: Int,
    var songsCount: Int
)

class ProfileJamsModel(var image: Int, var viewCount: String)