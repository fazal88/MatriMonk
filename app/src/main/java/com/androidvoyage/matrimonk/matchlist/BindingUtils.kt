package com.androidvoyage.matrimonk.matchlist

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.androidvoyage.matrimonk.R
import com.androidvoyage.matrimonk.database.MatchItem
import com.bumptech.glide.Glide


/*
@SuppressLint("SetTextI18n")
@BindingAdapter("profileName")
fun TextView.setProfileName(item: MatchItem) {
    item.let {
        text = it.name?.title + it.name?.first + it.name?.last
    }
}

@BindingAdapter("ProfileDetail")
fun TextView.setProfileDescription(item: MatchItem) {
    item.let {
        text = it.location?.city
    }
}

@BindingAdapter("profileStatus")
fun View.setProfileActive(item: MatchItem) {
    item.let {
        this.isSelected = it.gender.equals("Male")
    }
}

@BindingAdapter("profilePic")
fun ImageView.setProfileImage(item: MatchItem) {
    item.let {
        val link = it.picture?.large
        Glide.with(this).load(link).placeholder(R.drawable.ic_launcher_background).into(this)
    }
}*/
