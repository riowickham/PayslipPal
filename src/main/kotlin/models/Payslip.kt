package models

data class Payslip(
    var employeeId: Int,
    val employee: Employee,
    var normalHours: Double = 0.0,
    var sundayHours: Double = 0.0,
    var comForPeriod: Double = 0.0,
    var grossPay: Double = 0.0,
    var taxAmount: Double = 0.0,
    var netPay: Double = 0.0
)