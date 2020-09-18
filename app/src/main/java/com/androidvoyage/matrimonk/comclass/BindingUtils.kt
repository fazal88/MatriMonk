package com.androidvoyage.matrimonk.comclass

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.androidvoyage.matrimonk.database.MatchItem
import com.androidvoyage.matrimonk.matchlist.MatchListAdapter


@SuppressLint("SetTextI18n")
@BindingAdapter("profileName")
fun TextView.setProfileName(item: MatchItem) {
    item.let {
        text = it.name?.title+it.name?.first+it.name?.last
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
}

@BindingAdapter("profilePic")
fun ImageView.setProfileImage(item: MatchItem) {
    item.let {
        val link = it.picture?.large
        Glide.with(this).load(link).placeholder(R.drawable.ic_launcher_background).into(this)
    }
}*/
