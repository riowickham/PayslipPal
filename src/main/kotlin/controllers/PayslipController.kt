package controllers

import models.Payslip
import models.Employee
import services.PayslipServices

class PayslipController {
    private val payslipService = PayslipServices()

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
}