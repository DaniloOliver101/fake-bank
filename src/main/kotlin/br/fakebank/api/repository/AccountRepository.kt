package br.fakebank.api.repository

import br.fakebank.api.model.AccountData
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : ReactiveMongoRepository<AccountData, String> {
    // Os outros métodos da interface continuam aqui...
}
