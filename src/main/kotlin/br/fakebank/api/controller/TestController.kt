package br.fakebank.api.controller

import br.fakebank.api.model.CustomerData
import br.fakebank.api.repository.CustomerRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/test")
class TestController(val customerRepository: CustomerRepository) {

    @GetMapping
    suspend fun test(): Flux<CustomerData> {
        return customerRepository.findAll()
    }
}
