package com.androidvoyage.matrimonk.database.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Login(
    var uuid: String? = "",
    var username: String? = "",
    var password: String? = "",
    var salt: String? = "",
    var md5: String? = "",
    var sha1: String? = "",
    var sha256: String? = ""
) : Parcelable