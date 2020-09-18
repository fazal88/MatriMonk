package com.androidvoyage.matrimonk.database.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



@Parcelize
class Street(
    var number: Long = 0,
    var name: String? = ""
) : Parcelable
