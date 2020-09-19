package com.androidvoyage.matrimonk.comclass

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.androidvoyage.matrimonk.R
import com.androidvoyage.matrimonk.database.MatchItem
import com.androidvoyage.matrimonk.database.StatusMatch
import com.androidvoyage.matrimonk.matchlist.MatchListAdapter
import com.bumptech.glide.Glide
import java.util.*


//binders item adapter
@BindingAdapter("profileName")
fun TextView.setProfileName(item: MatchItem) {
    item.let {
        text = ("${it.name?.title}. ${it.name?.first} ${it.name?.last}")
    }
}

@BindingAdapter("profileAddress")
fun TextView.setProfileAddress(item: MatchItem) {
    item.let {
        text = ("${it.location?.city}. ${it.location?.state}")
    }
}

@BindingAdapter("profileGender")
fun TextView.setProfileGender(item: MatchItem) {
    item.let {
        isSelected = it.gender?.length == 4
        text = (it.gender?.capitalize(Locale.ENGLISH))
    }
}

@BindingAdapter("profileAge")
fun TextView.setProfileAge(item: MatchItem) {
    item.let {
        text = ("${it.dob?.age} years")
    }
}

@BindingAdapter("profileCountry")
fun TextView.setProfileCountry(item: MatchItem) {
    item.let {
        text = it.location?.country
    }
}

@BindingAdapter("profileStatus")
fun TextView.setProfileStatus(item: MatchItem) {
    item.let {
        if (it.status == StatusMatch.NOTA.status) {
            visibility = View.INVISIBLE
        } else {
            text = item.status
            isSelected = (it.status == StatusMatch.DECLINE.status)
            visibility = View.VISIBLE
        }
    }
}

@BindingAdapter("profileAction")
fun TextView.setProfileAction(item: MatchItem) {
    item.let {
        visibility = if (it.status == StatusMatch.NOTA.status) {
            View.VISIBLE
        } else {
            View.INVISIBLE
        }
    }
}

@BindingAdapter("profilePic")
fun ImageView.setProfileImage(item: MatchItem) {
    item.let {
        val link = it.picture?.large
        Glide.with(this).load(link).placeholder(R.drawable.ic_holder).into(this)
    }
}


// binders for list fragments
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

@BindingAdapter("clearAllVisibity")
fun View.setClearAllVisibility(size: Int) {
    size.let {
        visibility = if (size == 0) {
            View.INVISIBLE
        } else {
            View.VISIBLE
        }
    }
}

@BindingAdapter("setRefreshFinished")
fun SwipeRefreshLayout.setRefreshFinished(isloading : Boolean){
    isloading.let {
        if (!it) {
            isRefreshing = it
        }
    }
}
