package br.fakebank.model

data class AccountData
    (
    val accountId: String,

    val customer: CustomerData,
    val value: Double,
    val agency: String
)