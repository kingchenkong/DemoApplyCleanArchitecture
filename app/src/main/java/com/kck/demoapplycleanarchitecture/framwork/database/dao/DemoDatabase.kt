package com.kck.demoapplycleanarchitecture.framwork.database.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kck.demoapplycleanarchitecture.framwork.database.model.AccountDB


@Database(
    entities = [
        AccountDB::class,
    ],
    version = 1,
    exportSchema = true
)

abstract class DemoDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
}