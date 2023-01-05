package com.kck.demoapplycleanarchitecture.data.repository

import com.kck.demoapplycleanarchitecture.business_rule.entity.Account
import com.kck.demoapplycleanarchitecture.SourceType

interface IAccountRepository {
    suspend fun getAccount(sourceType: SourceType): Account
}