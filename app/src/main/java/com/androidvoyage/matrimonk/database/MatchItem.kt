package com.androidvoyage.matrimonk.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

 enum class StatusMatch(val status : String) {
         ACCEPT("Member Accepted"),
         DECLINE("Member Declined"),
         NOTA("None")
 }

@Parcelize
@Entity(tableName = "matches_entry_table")
data class MatchItem(

        @PrimaryKey(autoGenerate = true)
        var matchId: Long = 0L,

        @ColumnInfo(name = "gender")
        var gender: String? = "Male",

        @ColumnInfo(name = "email")
        var email: String? = "yoyo@gmail.com",

        @ColumnInfo(name = "phone")
        var phone: String? = "",

        @ColumnInfo(name = "cell")
        var cell: String? = "",

        @ColumnInfo(name = "nat")
        var nat: String? = "",

        @ColumnInfo(name = "status")
        var status: String = StatusMatch.NOTA.status,

        @Embedded
        var name: Name? = Name(),

        @Embedded
        var login: Login? = Login(),

        @Embedded
        var dob: Dob? = Dob(),

        @Embedded(prefix = "id_")
        var id: Id? = Id(),

        @Embedded
        var picture: Picture? = Picture(),

        @Embedded(prefix = "reg_")
        var registered: Registered? = Registered(),

        @Embedded(prefix = "loc_")
        var location: Location? = Location()



) : Parcelable


@Parcelize
class Dob(
        var date: String? = "",
        var age: Int? = 0
) : Parcelable

@Parcelize
class Id(
        var name: String? = "",
        var value: String? = ""
) : Parcelable


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

@Parcelize
data class Name(
        var title: String? = "",
        var first: String? = "",
        var last: String? = ""
) : Parcelable


@Parcelize
class Picture(
        var large: String? = "",
        var medium: String? = "",
        var thumbnail: String? = ""
) : Parcelable

@Parcelize
class Registered(
        var date: String? = "",
        var age: String? = ""
) : Parcelable

@Parcelize
class Street(
        var number: Long = 0,
        var name: String? = ""
) : Parcelable

@Parcelize
class Timezone(
        var offset: String? = "",
        var description: String? = ""
) : Parcelable


@Parcelize
class Coordinates(
        var latitude: String? = "",
        var longitude: String? = ""
) : Parcelable