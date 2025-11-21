package controllers

import models.Payslip
import models.Employee
import services.PayslipServices

class PayslipController {
    private val payslipService = PayslipServices()

    fun printPayslip(employee: Employee, payslip: Payslip): String {
        return payslipService.printPayslip(employee, payslip)
    }
}