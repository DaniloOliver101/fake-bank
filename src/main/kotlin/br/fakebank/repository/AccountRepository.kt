package br.fakebank.repository

import br.fakebank.model.AccountData
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : ReactiveMongoRepository<AccountData, String> {
    // Os outros métodos da interface continuam aqui...
}
