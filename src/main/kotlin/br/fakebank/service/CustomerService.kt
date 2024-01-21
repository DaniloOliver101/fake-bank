package br.fakebank.service


import br.fakebank.model.CustomerData
import br.fakebank.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class CustomerService(
    @Autowired
    val customerRepository: CustomerRepository
) {

    fun create(customerData: CustomerData) {

        customerRepository.save(customerData).subscribe { savedCustomerData ->
            println("CustomerData salvo com sucesso: $savedCustomerData")
        }
    }

    fun getAllCustomers(): Flux<CustomerData> {

            return customerRepository.findAll()
                .onErrorMap(DataAccessException::class.java) {
                    ValidateException(buildString {
        append("Erro ao buscar todos os clientes")
    }, HttpStatus.INTERNAL_SERVER_ERROR)
                }

}

    private fun ValidateException(httpStatusCode: String, message: HttpStatus): Throwable? {
        //imprimir os parametros
        return null
    }

    fun update(customer: CustomerData) {

    }

    fun deleteCustomerById(id: String) {
customerRepository.deleteById(id)
        .onErrorMap(DataAccessException::class.java) {
            ValidateException(buildString {
                append("Erro ao deletar o cliente com id: $id")
            }, HttpStatus.INTERNAL_SERVER_ERROR)
        }
        customerRepository.deleteById(id).subscribe()
    }
}
