package br.fakebank.api.service


import br.fakebank.api.model.CustomerData
import br.fakebank.api.repository.CustomerRepository
import org.springframework.dao.DataAccessException
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class CustomerService(

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
                    ValidateException
                }

}

    fun update(customer: CustomerData) {

    }

    fun deleteCustomerById(id: String) {
customerRepository.deleteById(id)
        .onErrorMap(DataAccessException::class.java) {
            ValidateException
        }
        customerRepository.deleteById(id).subscribe()
    }
}

private val ValidateException: Throwable?
    get() {

        return null
    }
