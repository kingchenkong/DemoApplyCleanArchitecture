package com.kck.demoapplycleanarchitecture.framwork.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.kck.demoapplycleanarchitecture.framwork.database.model.AccountDB

@Dao
interface AccountDao {

    @Query("SELECT * FROM account")
    suspend fun getAll(): List<AccountDB>

    @Query("SELECT * FROM account WHERE serialNumber == :serialNumber AND password == :password")
    suspend fun getAccountList(
        serialNumber: String,
        password: String,
    ): List<AccountDB>

    @Insert
    suspend fun addAccount(account: AccountDB)

    @Update
    suspend fun updateAccount(account: AccountDB)
}