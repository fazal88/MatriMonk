package com.androidvoyage.matrimonk.database.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Registered(
    var date: String? = "",
    var age: String? = ""
) : Parcelable
