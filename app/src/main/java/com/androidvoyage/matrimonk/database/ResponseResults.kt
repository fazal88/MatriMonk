package com.androidvoyage.matrimonk.database

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseResults(
    val results: List<MatchItem>,
    val info: Info

) : Parcelable


@Parcelize
data class Info(
    var seed: String = "",
    var results: Int = 0,
    var page: Int = 0,
    var version: String = ""

) : Parcelable