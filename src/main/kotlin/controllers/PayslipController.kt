package controllers

import models.Payslip
import models.Employee
import services.PayslipServices

class PayslipController {
    private val payslipService = PayslipServices()

    private var payslips = ArrayList<Payslip>()

    fun printPayslip(employee: Employee, payslip: Payslip): String {
        payslipService.payslipCalculator(payslip)
        return ("""
        > ---------------------------
        > |       Payslip           |
        > --------------------------- 
        > | ${employee.name}                          |
        > | Weekday Hours worked: ${payslip.normalHours}  |
        > | Sunday Hours worked: ${payslip.sundayHours}   |
        > | Commission: ${payslip.comForPeriod}                     |
        > |------------------------------|
        > | Gross Pay: ${payslip.grossPay}                        |
        > | PAYE ${employee.taxPercentage}: ${payslip.taxAmount}
        > | Net Pay: ${payslip.netPay}
        > | Annual Salary: ${payslipService.annualSalary(payslip)}
        > ---------------------------
        > |   0) Exit               | 
        > ---------------------------
        >""".trimMargin(">"))
    }

    fun add(payslip: Payslip): Boolean {
        return payslips.add(payslip)
    }

    fun numberOfPayslips(): Int {
        return payslips.size
    }

    fun findPayslip(index: Int): Payslip? {
        return if (isValidListIndex(index, payslips)) {
            payslips[index]
        } else null
    }

    fun isValidListIndex(index: Int, list: List<Any>): Boolean {
        return (index >= 0 && index < list.size)
    }

    fun listAllPayslips(): String {
        return if (payslips.isEmpty()) {
            "No payslips stored"
        } else {
            var listOfPayslips = ""
            for (i in payslips.indices) {
                listOfPayslips += "${i}: ${payslips[1]} \n"
            }
            listOfPayslips
        }
    }
}