package br.fakebank.api.service

import br.fakebank.api.model.CustomerData
import org.springframework.stereotype.Service

@Service
class AccountService {
    fun create(customer : CustomerData){
        validateCPf("12345678901")
        validateName("Danilo")

    }
    fun validateCPf (cpf: String): Boolean {
        return cpf.length == 11

    }
    fun validateName(name: String?): Boolean {
        return !name.isNullOrBlank()
    }
}