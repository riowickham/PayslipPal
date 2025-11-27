package controllers

import models.Employee

class AppController
{
    private val employees = ArrayList<Employee>()


    fun addEmployee(employee: Employee) {
        employees.add(employee)
    }
}