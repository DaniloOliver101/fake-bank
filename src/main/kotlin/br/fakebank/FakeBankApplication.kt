package br.fakebank

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FakeBankApplication

fun main(args: Array<String>) {
	runApplication<FakeBankApplication>(*args)
}
