package com.androidvoyage.matrimonk.comclass

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.androidvoyage.matrimonk.R
import com.androidvoyage.matrimonk.database.MatchItem
import com.androidvoyage.matrimonk.matchlist.MatchListAdapter
import com.bumptech.glide.Glide


@SuppressLint("SetTextI18n")
@BindingAdapter("profileName")
fun TextView.setProfileName(item: MatchItem) {
    item.let {
        text = "${it.name?.title}. ${it.name?.first} ${it.name?.last}"
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("profileAddress")
fun TextView.setProfileAddress(item: MatchItem) {
    item.let {
        text = "${it.location?.city}. ${it.location?.state}"
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("profileGender")
fun TextView.setProfileGender(item: MatchItem) {
    item.let {
        isSelected = it.gender.equals("Male")
        text = it.gender?.capitalize()
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("profileAge")
fun TextView.setProfileAge(item: MatchItem) {
    item.let {
        text = "${it.dob?.age} years"
    }
}

@SuppressLint("SetTextI18n")
@BindingAdapter("profileCountry")
fun TextView.setProfileCountry(item: MatchItem) {
    item.let {
        text = it.location?.country
    }
}

@BindingAdapter("submitList")
fun bindRecyclerView(recyclerView: RecyclerView, list: List<MatchItem>?) {
    val adapter = recyclerView.adapter as MatchListAdapter
    adapter.submitList(list)
}

@BindingAdapter("errorText")
fun TextView.setNoDataText(errorMsg: String?) {
    errorMsg.let {
        if (it!!.isEmpty()) {
            visibility = View.GONE
        } else {
            text = it
            visibility = View.VISIBLE
        }
    }
}

/*@BindingAdapter("ProfileDetail")
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
}*/

@BindingAdapter("profilePic")
fun ImageView.setProfileImage(item: MatchItem) {
    item.let {
        val link = it.picture?.large
        Glide.with(this).load(link).placeholder(R.drawable.ic_holder).into(this)
    }
}
