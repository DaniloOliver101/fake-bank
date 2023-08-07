package br.fakebank.repository

import br.fakebank.model.CustomerData
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : ReactiveMongoRepository<CustomerData, String> {
    // Os outros métodos da interface continuam aqui...
}
