package br.fakebank.api.repository

import br.fakebank.api.model.CustomerData
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : ReactiveMongoRepository<CustomerData, String> {
    // Os outros métodos da interface continuam aqui...
}
