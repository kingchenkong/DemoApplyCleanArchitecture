package com.kck.demoapplycleanarchitecture.data.data_source

import com.kck.demoapplycleanarchitecture.business_rule.entity.Account
import com.kck.demoapplycleanarchitecture.framwork.database.IDatabaseProvider
import com.kck.demoapplycleanarchitecture.interface_adapters.toEntity

class AccountLocalDataSourceImpl(
    private val dataProvider: IDatabaseProvider
) : IAccountLocalDataSource {

    override suspend fun getAccount(
        serialNumber: String, password: String
    ): Result<List<Account>> = dataProvider.getAccountList(serialNumber, password).let {
        Result.success(it.map { accountDB ->
            accountDB.toEntity()
        })
    }

}