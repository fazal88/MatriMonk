package com.androidvoyage.matrimonk.database.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Coordinates(
    var latitude: String? = "",
    var longitude: String? = ""
) : Parcelable
