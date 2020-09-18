package com.androidvoyage.matrimonk.database.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Id(
    var name: String? = "",
    var value: String? = ""
) : Parcelable
