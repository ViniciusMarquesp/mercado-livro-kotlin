package com.mercadolivro.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController //Falando para o Spring que essa classe eh uma controller
class CustomerController {

    //endpoint get
    @GetMapping
    fun helloWorld(): String {
        return "Hello World"
    }
}