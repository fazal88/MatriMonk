package com.androidvoyage.matrimonk.database.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Dob(
    var date: String? = "",
    var age: Int? = 0
) : Parcelable
