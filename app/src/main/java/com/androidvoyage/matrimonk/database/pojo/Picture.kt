package com.androidvoyage.matrimonk.database.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Picture(
    var large: String? = "",
    var medium: String? = "",
    var thumbnail: String? = ""
) : Parcelable
