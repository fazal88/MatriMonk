package com.androidvoyage.matrimonk.database.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



@Parcelize
data class Name(
    var title: String? = "",
    var first: String? = "",
    var last: String? = ""
) : Parcelable
