package br.fakebank.api.controller

import br.fakebank.api.model.CustomerData
import br.fakebank.api.service.CustomerService
import br.fakebank.mainframe.service.MainframeService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import org.springframework.http.ResponseEntity as ResponseEntity1


@RestController
@RequestMapping("/customer")
class CustomerController(val customerService: CustomerService,
val mainframeService: MainframeService) {

    @DeleteMapping("/v1/{id}")
    fun deleteCustomerById(
        @PathVariable("id") id: String
      ): ResponseEntity1<Any> {
        customerService.deleteCustomerById(id)
        return ResponseEntity1.status(200)
            .build()
    }

    @PutMapping("/v1")
    fun updateCustomer(@RequestBody customer: CustomerData): ResponseEntity1<Any> {
        customerService.update(customer)
        return ResponseEntity1.status(200).build()
    }

    @GetMapping("/v1")
    fun getAllCustomers(): Flux<CustomerData> {
        val response = mainframeService.sendMainframeRequest()
        println(response)
        return customerService.getAllCustomers()



            }
    @PostMapping("/v1")
fun createCustomer(@RequestBody customer: CustomerData): ResponseEntity1<Any> {
    customerService.create(customer)
    return ResponseEntity1.status(201).build()
}
}
