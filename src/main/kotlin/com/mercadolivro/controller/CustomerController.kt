package com.mercadolivro.controller

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController //Falando para o Spring que essa classe eh uma controller
@RequestMapping("customer") //declarando o caminho que o controllador eh referente
class CustomerController {
    //criei uma lista mutavel usando a model pra quando der o Get ele retornar uma lista com os dados criados no Post
    val customers = mutableListOf<CustomerModel>()

    //endpoint get
    @GetMapping
    //puxei a lista e retornei ela
    fun getCustomer(): MutableList<CustomerModel> {
        return customers
    }

    //criei o objeto customer que recebe as variaveis que o usuario inserir de acordo
    // com o padrao do PostCustomerRequest, e o @RequestBody espera os dados serem inseridos pelo user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) //definindo que a resposta HTTP apos usar o metodo Post, sera 201
    fun create(@RequestBody customer: PostCustomerRequest) {

        //definindo que sempre quie a lista tiver vazia, o primeiro cara sera 1, caso o contrario, ela colocara +1. TO STRING no final faz eles virarem string
        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id.toInt() + 1
        } .toString()


        customers.add(CustomerModel(id, customer.name, customer.email))
        println(customer)
    }
}