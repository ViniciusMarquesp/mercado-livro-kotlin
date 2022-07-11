package com.mercadolivro.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController //Falando para o Spring que essa classe eh uma controller
@RequestMapping("customer") //declarando o caminho que o controllador eh referente
class CustomerController {

    //endpoint get
    @GetMapping
    fun helloWorld(): String {
        return "Customer 1"
    }
}