package com.mercadolivro.controller.request
//criei usando as mesmas variaveis da CustomerModel, tirando o ID
data class PostCustomerRequest (
    var name: String,
    var email: String

)