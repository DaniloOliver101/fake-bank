package br.fakebank.controller

import br.fakebank.model.CustomerData
import br.fakebank.service.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/customer")
class CustomerController(val customerService: CustomerService) {

    @GetMapping("/v1")
    fun getAllCustomers(): Flux<CustomerData> {
        return customerService.getAllCustomers()


            }
    @PostMapping("/v1")
fun createCustomer(@RequestBody customer: CustomerData): ResponseEntity<Any> {
    customerService.create(customer)
    println("customer criado!")
    return ResponseEntity.status(201).build()
}
}
