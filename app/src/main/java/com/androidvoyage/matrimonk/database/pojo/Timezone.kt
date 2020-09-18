package com.androidvoyage.matrimonk.database.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Timezone(
    var offset: String? = "",
    var description: String? = ""
) : Parcelable
