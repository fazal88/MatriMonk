package com.androidvoyage.matrimonk.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.androidvoyage.matrimonk.database.pojo.*
import kotlinx.android.parcel.Parcelize

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