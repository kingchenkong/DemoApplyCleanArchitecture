package com.kck.demoapplycleanarchitecture.framwork.database

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Room
import com.kck.demoapplycleanarchitecture.framwork.database.dao.DemoDatabase
import com.kck.demoapplycleanarchitecture.framwork.database.model.AccountDB

class DatabaseProviderImpl(context: Context) : IDatabaseProvider {

    private val database: DemoDatabase by lazy { buildDataBase(context) }

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    internal fun buildDataBase(
        context: Context,
    ): DemoDatabase {
        val name = "db_demo"
        return Room.databaseBuilder(
            context,
            DemoDatabase::class.java,
            name
        ).build()
    }

    // for init db table
    override suspend fun initialize(context: Context) {
        if (database.accountDao().getAll().isEmpty()) {
            database.accountDao().addAccount(
                AccountDB(
                    id = 0,
                    serialNumber = "1234 5678 9012 3456",
                    password = "asdfqwer1234",
                    balance = 0,
                    displayName = "default_name",
                )
            )
        }
    }

    override suspend fun getAllAccount(): List<AccountDB> = database.accountDao().getAll()

    override suspend fun getAccountList(
        serialNumber: String,
        password: String
    ): List<AccountDB> =
        database.accountDao().getAccountList(
            serialNumber = serialNumber,
            password = password
        )

}