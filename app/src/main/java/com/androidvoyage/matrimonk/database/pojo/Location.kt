package com.androidvoyage.matrimonk.database.pojo

import android.os.Parcelable
import androidx.room.Embedded
import kotlinx.android.parcel.Parcelize


@Parcelize
class Location(
    var city: String? = "",
    var state: String? = "Maharashtra",
    var country: String? = "INDIA",
    var postcode: String? = "",
    @Embedded
    var street: Street? = Street(),
    @Embedded
    var coordinates: Coordinates? = Coordinates(),
    @Embedded
    var timezone: Timezone? = Timezone()
) : Parcelable
