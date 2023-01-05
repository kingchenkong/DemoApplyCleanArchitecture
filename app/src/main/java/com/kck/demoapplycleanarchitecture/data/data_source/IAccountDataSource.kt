package com.kck.demoapplycleanarchitecture.data.data_source

import com.kck.demoapplycleanarchitecture.business_rule.entity.Account

interface IAccountDataSource {
    suspend fun getAccount(
        serialNumber: String,
        password: String,
    ): Result<List<Account>>
}