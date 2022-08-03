package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.model.CustomerModel
import com.mercadolivro.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController //Falando para o Spring que essa classe eh uma controller
@RequestMapping("customer") //declarando o caminho que o controllador eh referente
class CustomerController(
    val customerService : CustomerService
) {
    //endpoint get
    @GetMapping
    //puxei a lista e retornei ela
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAll(name)
    }

    //criei o objeto customer que recebe as variaveis que o usuario inserir de acordo
    // com o padrao do PostCustomerRequest, e o @RequestBody espera os dados serem inseridos pelo user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //definindo que a resposta HTTP apos usar o metodo Post, sera 201
    fun create(@RequestBody customer: PostCustomerRequest) {
        customerService.create(customer)
    }

    //declarando um valor dinamico para ser chamado na url
    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): CustomerModel {
        return customerService.getCustomer(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: String, @RequestBody customer: PutCustomerRequest) {
        customerService.update(id, customer)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) {
        customerService.delete(id)
        }
}