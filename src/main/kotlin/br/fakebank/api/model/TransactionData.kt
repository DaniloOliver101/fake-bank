package br.fakebank.api.model

data class TransactionData
    (
    val transactionId: String,
    val origin: AccountData,
    val accountReceiver: AccountData,
    val date: String,
    val value: Double,
    val agency: String
)