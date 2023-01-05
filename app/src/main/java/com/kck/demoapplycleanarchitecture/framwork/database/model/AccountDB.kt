package com.kck.demoapplycleanarchitecture.framwork.database.model

import android.os.Parcelable
import androidx.room.Entity

@Entity(tableName = "account", primaryKeys = ["id"])
//@Parcelize
data class AccountDB(
    val id: Int,
    val serialNumber: String,
    val password: String,
    val balance: Int,
    val displayName: String,
)
//    : Parcelable
{
    override fun toString(): String {
        return "AccountDB (id=$id, serialNumber='$serialNumber', password='$password', balance=$balance, displayName='$displayName' )"
    }
}
