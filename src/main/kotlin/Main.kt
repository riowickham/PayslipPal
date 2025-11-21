import controllers.PayslipController
import utils.readNextDouble
import utils.readNextInt
import utils.readNextLine
import services.PayslipServices
import models.Employee
import models.Payslip

private val payslipController = PayslipController()
private val payslipServices = PayslipServices()

private var employee: Employee? = null
private var payslip: Payslip? = null

fun main() {
    val name = readNextLine("Please enter your name: ")

    employee = Employee(
        name = name,
        payFreq = 0,
        hourlyPay = 0.0,
        sundayPay = 0.0,
        taxPercentage = 20.0
    )

    payslip = Payslip(employee!!)

    runMenu()
}

fun mainMenu(): Int {
    print(
        """
        > ---------------------------
        > |       Payslip Pal       |
        > ---------------------------
        > | Info Menu               |
        > |   1) Log Hourly Pay     |
        > |   2) Log Sunday Pay     |
        > |   3) Commission Tool    |
        > |   4) Log Hours for slip |
        > |   5) Payment Frequency  |
        > ---------------------------
        > |   6) Print Slip         |
        > ---------------------------
        > |   0) Exit               |
        > ---------------------------
        >""".trimMargin(">")
    )
    return readNextInt(" > ==>>")
}

fun runMenu() {
    do {
        val option = mainMenu()
        when (option) {
            1 -> logHourlyPay()
            2 -> logSundayPay()
            3 -> commissionsTool()
            4 -> logHours()
            5 -> paymentFrequency()
            6 -> printPayslip()
            0 -> exit()
            else -> println("!Invalid Option!")
        }
    } while(true)
}

fun logHourlyPay(){
    employee?.hourlyPay = readNextDouble("What is your hourly pay?: ")
}

fun logSundayPay(){
    employee?.sundayPay = readNextDouble("What is your pay for Sundays?: ")
}

fun commissionsTool(){
    payslip?.comForPeriod = readNextDouble("Please enter commissions gained for this pay period (0 for none): ")
}

fun logHours(){
    payslip?.normalHours = readNextDouble("Please enter your hours worked for this period(excluding breaks): ")
    payslip?.sundayHours = readNextDouble("Please enter your hours worked for Sunday(s): ")
}

fun paymentFrequency() {
    employee?.payFreq = readNextInt("Do you get paid (1) Weekly, (2) Biweekly, (3) Monthly:")
}

fun printPayslip(){
    if (employee == null || payslip == null) {
        println("Please make an employee and log their hours.")
        return
    }

    println(payslipController.printPayslip(employee!!, payslip!!))
}

fun exit() {
    println("Exiting!")
    return
}