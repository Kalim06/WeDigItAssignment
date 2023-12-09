package com.example.wedigitassignment.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter


//Profile
@BindingAdapter("userImage")
fun ImageView.setUserImage(item: UserProfile?) {
    item?.let {
        setImageResource(it.userImage)
    }
}

@BindingAdapter("userRating")
fun TextView.setRating(item: UserProfile?) {
    item?.let {
        text = it.ratingCount.toString()
    }
}

@BindingAdapter("userPlays")
fun TextView.setPlaysCount(item: UserProfile?) {
    item?.let {
        text = it.playCount.toString()
    }
}

@BindingAdapter("userFriends")
fun TextView.setFriendsCount(item: UserProfile?) {
    item?.let {
        text = it.friendsCount.toString()
    }
}

@BindingAdapter("userSongs")
fun TextView.setSongsCount(item: UserProfile?) {
    item?.let {
        text = it.songsCount.toString()
    }
}

//RecyclerView
@BindingAdapter("jamsViewCount")
fun TextView.setViewCount(item: ProfileJamsModel?) {
    item?.let {
        text = it.viewCount
    }
}

@BindingAdapter("jamsImage")
fun ImageView.setJamsImage(item: ProfileJamsModel?) {
    item?.let {
        setImageResource(it.image)
    }
}