package services

import models.Employee
import models.Payslip


class PayslipServices {

    fun payslipCalculator(payslip: Payslip) {
        val employee = payslip.employee

        payslip.grossPay = (employee.hourlyPay * payslip.normalHours) + (employee.sundayPay * payslip.sundayHours) + payslip.comForPeriod

        payslip.taxAmount = payslip.grossPay * (employee.taxPercentage / 100)
        payslip.netPay = payslip.grossPay - payslip.taxAmount
    }

    fun annualSalary(payslip: Payslip): Double {
        val employee = payslip.employee
        val periods = when (employee.payFreq) {
            1 -> 52
            2 -> 26
            3 -> 12
            else -> 0
        }
        return payslip.grossPay * periods
    }
}