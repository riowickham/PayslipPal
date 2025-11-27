package controllers

import models.Employee
import models.Payslip

class AppController {
    private val employees = ArrayList<Employee>()
    private val payslips = ArrayList<Payslip>()

    fun addEmployee(employee: Employee) {
        employees.add(employee)
    }

    fun addPayslip(payslip: Payslip) {
        payslips.add(payslip)
    }

    fun getPayslipsByEmployeeId(employeeId: Int): List<Payslip> {
        return payslips.filter { it.employeeId == employeeId }
    }

    fun getAllPayslips(): List<Payslip> {
        return payslips
    }

    fun getEmployeeById(employeeId: Int): Employee? {
        return employees.find { it.employeeId == employeeId }
    }

    fun getAllEmployees(): List<Employee> {
        return employees
    }
}