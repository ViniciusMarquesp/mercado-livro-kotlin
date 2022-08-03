package com.mercadolivro.service

import com.mercadolivro.model.CustomerModel
import org.springframework.stereotype.Service

@Service
class CustomerService {

    //criei uma lista mutavel usando a model pra quando der o Get ele retornar uma lista com os dados criados no Post
    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {  //o name com interroga indica que pode vir null
            return customers.filter { it.name.contains(name, true) } //filtrando o nome e declarando ignoreCase
        }
        return customers
    }

    fun create(customer: CustomerModel) {

        //definindo que sempre quie a lista tiver vazia, o primeiro cara sera 1, caso o contrario, ela colocara +1. TO STRING no final faz eles virarem string
        val id = if (customers.isEmpty()) {
            1
        } else {
            customers.last().id!!.toInt() + 1
        } .toString()

        customer.id = id

        customers.add(customer)
    }

    fun getCustomer(id: String): CustomerModel {
        return customers.filter { it.id == id }.first() //se o registro tiver um id igual ao q passou pela url ele retorna. o .first pega o 1 registro
    }

    fun update(customer: CustomerModel) {
        //declaro com ir dentro do let as variaveis que eu tenho na costumer model
        customers.filter { it.id == customer.id }.first().let {
            it.name = customer.name
            it.email = customer.email
        }
    }

    fun delete(id: String) {
        customers.removeIf { it.id == id }
    }

}