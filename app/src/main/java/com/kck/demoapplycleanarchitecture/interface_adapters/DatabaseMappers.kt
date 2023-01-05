package com.kck.demoapplycleanarchitecture.interface_adapters

import com.kck.demoapplycleanarchitecture.business_rule.entity.Account
import com.kck.demoapplycleanarchitecture.framwork.database.model.AccountDB

/**
 * Account Mappers
 */
fun AccountDB.toEntity(): Account {
    return Account(
        id = id,
        serialNumber = serialNumber,
        password = password,
        displayName = displayName,
        balance = balance,
    )
}