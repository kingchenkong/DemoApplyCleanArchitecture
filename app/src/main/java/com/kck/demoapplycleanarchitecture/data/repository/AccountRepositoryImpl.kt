package com.kck.demoapplycleanarchitecture.data.repository

import com.kck.demoapplycleanarchitecture.SourceType
import com.kck.demoapplycleanarchitecture.business_rule.entity.Account
import com.kck.demoapplycleanarchitecture.data.data_source.IAccountLocalDataSource

class AccountRepositoryImpl(
    private val serialNumber: String,
    private val password: String,
    private val localDataSource: IAccountLocalDataSource
) : IAccountRepository {

    override suspend fun getAccount(sourceType: SourceType): Account {
        val datasource = if (sourceType == SourceType.LOCAL) {
            localDataSource
        } else {
            null
        }
        return datasource?.getAccount(serialNumber, password)!!.getOrThrow()[0]
    }
}