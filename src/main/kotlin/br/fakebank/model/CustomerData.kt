package br.fakebank.model

import org.springframework.data.mongodb.core.mapping.Document


@Document(  collection = "customer")
data class CustomerData
    (
val id : Long? = null,
    val name: String,
    val cpf: String
    )
