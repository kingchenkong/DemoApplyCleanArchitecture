package com.kck.demoapplycleanarchitecture.framwork.database

import android.content.Context
import com.kck.demoapplycleanarchitecture.framwork.database.model.AccountDB

interface IDatabaseProvider {
    suspend fun initialize(context: Context)

    suspend fun getAllAccount(): List<AccountDB>
    suspend fun getAccountList(serialNumber: String, password: String): List<AccountDB>
}