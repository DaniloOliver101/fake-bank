package br.fakebank.model

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.annotation.Id


@Document(  collection = "customer")
data class CustomerData
    (
    @Id
    val id : Long? = null,
    val name: String,
    val cpf: String
    )
