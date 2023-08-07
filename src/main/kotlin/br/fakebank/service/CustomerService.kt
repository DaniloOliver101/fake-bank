package br.fakebank.service

import br.fakebank.exception.ValidateException
import br.fakebank.repository.CustomerRepository
import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import br.fakebank.model.CustomerData

@Service
class CustomerService(val customerRepository: CustomerRepository) {
    fun getAllCustomers(): Flux<CustomerData> {
        return try {
            customerRepository.findAll()
        } catch (ex: DataAccessException) {
            // Tratar a exceção de acesso a dados (DataAccessException) aqui
            // Pode ser um erro de conexão com o banco de dados ou consulta inválida
            // Logar a exceção ou retornar uma mensagem de erro apropriada
            // Exemplo de log: ex.printStackTrace()
            Flux.error(ex) // ou outro comportamento adequado em caso de erro
        }
    }
    fun create(customerData: CustomerData) {
        print(customerData.name)
        print(customerData.cpf)
        customerRepository.save(customerData)
        print("Novo registro de customer")
    }

    private fun isValidCpf(cpf: String): Boolean {
        return cpf.length == 11
    }

    private fun isValidName(name: String?): Boolean {
        return !name.isNullOrBlank()
    }
}
