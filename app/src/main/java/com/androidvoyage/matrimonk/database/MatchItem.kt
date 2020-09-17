package com.androidvoyage.matrimonk.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "matches_entry_table")
data class MatchItem(

        @PrimaryKey(autoGenerate = true)
        var matchId: Long? = 0L,

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

        /*@Embedded
        var name: Name? = Name(),

        @Embedded
        var location: Location? = Location(),

        @Embedded
        var login: Login? = Login(),

        @Embedded
        var dob: Dob? = Dob(),

        @Embedded
        var registered: Registered? = Registered(),

        @Embedded
        var id: Id? = Id(),

        @Embedded
        var picture: Picture? = Picture(),*/

        ) : Parcelable

@Parcelize
data class Name(
        @ColumnInfo(name = "title")
        var title: String? = "",
        @ColumnInfo(name = "first")
        var first: String? = "",
        @ColumnInfo(name = "last")
        var last: String? = ""
) : Parcelable

@Parcelize
class Street(
        @ColumnInfo(name = "number")
        var number: Long = 0,
        @ColumnInfo(name = "street_name")
        var name: String? = ""
) : Parcelable

@Parcelize
class Coordinates(
        @ColumnInfo(name = "latitude")
        var latitude: String? = "",
        @ColumnInfo(name = "longitude")
        var longitude: String? = ""
) : Parcelable

@Parcelize
class Timezone(
        @ColumnInfo(name = "offset")
        var offset: String? = "",
        @ColumnInfo(name = "description")
        var description: String? = ""
) : Parcelable

@Parcelize
class Location(
        @ColumnInfo(name = "street")
        var street: Street? = Street(),
        @ColumnInfo(name = "city")
        var city: String? = "",
        @ColumnInfo(name = "state")
        var state: String? = "Maharashtra",
        @ColumnInfo(name = "country")
        var country: String? = "INDIA",
        @ColumnInfo(name = "postcode")
        var postcode: String? = "",
        @ColumnInfo(name = "coordinates")
        var coordinates: Coordinates? = Coordinates(),
        @ColumnInfo(name = "timezone")
        var timezone: Timezone? = Timezone()
) : Parcelable

@Parcelize
class Login(
        @ColumnInfo(name = "uuid")
        var uuid: String? = "",
        @ColumnInfo(name = "username")
        var username: String? = "",
        @ColumnInfo(name = "password")
        var password: String? = "",
        @ColumnInfo(name = "salt")
        var salt: String? = "",
        @ColumnInfo(name = "md5")
        var md5: String? = "",
        @ColumnInfo(name = "sha1")
        var sha1: String? = "",
        @ColumnInfo(name = "sha256")
        var sha256: String? = ""
) : Parcelable

@Parcelize
class Dob(
        @ColumnInfo(name = "date")
        var date: String? = "",
        @ColumnInfo(name = "age")
        var age: Int? = 0
) : Parcelable

@Parcelize
class Registered(
        @ColumnInfo(name = "join_date")
        var date: String? = "",
        @ColumnInfo(name = "join_age")
        var age: String? = ""
) : Parcelable

@Parcelize
class Id(
        @ColumnInfo(name = "id_name")
        var name: String? = "",
        @ColumnInfo(name = "id_value")
        var value: String? = ""
) : Parcelable

@Parcelize
class Picture(
        @ColumnInfo(name = "large")
        var large: String? = "",
        @ColumnInfo(name = "medium")
        var medium: String? = "",
        @ColumnInfo(name = "thumbnail")
        var thumbnail: String? = ""
) : Parcelable