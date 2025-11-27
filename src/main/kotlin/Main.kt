import controllers.PayslipController
import controllers.AppController
import utils.readNextDouble
import utils.readNextInt
import utils.readNextLine
import services.PayslipServices
import models.Employee
import models.Payslip

private val payslipController = PayslipController()
private val appController = AppController()

private var employee: Employee? = null
private var payslip: Payslip? = null

fun main() {
    val name = readNextLine("Please enter your name: ")

    employee = Employee(
        name = name,
        employeeId = 0,
        payFreq = 0,
        hourlyPay = 0.0,
        sundayPay = 0.0,
        taxPercentage = 20.0
    )

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
        > |   4) Payment Frequency  |
        > |   5) Employee ID        |
        > ---------------------------
        > | Payslip Menu            |
        > |   6) Create New Payslip |
        > |   7) View All Payslips  |
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
            4 -> paymentFrequency()
            5 -> employeeID()
            6 -> createNewPayslip()
            7 -> viewAllPayslips()
            0 -> exit()
            else -> println("!Invalid Option!")
        }
    } while(true)
}

fun logHourlyPay(){
    employee?.hourlyPay = readNextDouble("What is your hourly pay?: ")
    println("Hourly pay updated successfully!")
}

fun logSundayPay(){
    employee?.sundayPay = readNextDouble("What is your pay for Sundays?: ")
    println("Sunday pay updated successfully!")
}

fun commissionsTool(){
    payslip?.comForPeriod = readNextDouble("Please enter commissions gained for this pay period (0 for none): ")
}

fun logHours(){
    payslip?.normalHours = readNextDouble("Please enter your hours worked for this period(excluding breaks): ")
    payslip?.sundayHours = readNextDouble("Please enter your hours worked for Sunday(s): ")
}

fun paymentFrequency() {
    employee?.payFreq = readNextInt("Do you get paid (1) Weekly, (2) Biweekly, (3) Monthly: ")
    println("Payment frequency updated successfully!")
}

fun employeeID() {
    employee?.employeeId = readNextInt("Please Enter Your Employee ID: ")
    println("Employee ID updated successfully!")
}

fun printPayslip(){
    if (employee == null || payslip == null) {
        println("Please make an employee and log their hours.")
        return
    }

    println(payslipController.printPayslip(employee!!, payslip!!))
}



fun createNewPayslip() {
    if (employee == null) {
        println("Error: No employee information available!")
        return
    }

    if (employee!!.hourlyPay == 0.0) {
        println("Please set your hourly pay first (Option 1)!")
        return
    }

    // Get/confirm employee ID for this payslip
    val employeeId = readNextInt("Please enter your Employee ID: ")
    employee!!.employeeId = employeeId

    // Create new payslip
    val newPayslip = Payslip(
        employeeId = employeeId,
        employee = employee!!
    )

    // Get payslip details
    newPayslip.normalHours = readNextDouble("Please enter your hours worked for this period (excluding breaks): ")
    newPayslip.sundayHours = readNextDouble("Please enter your hours worked for Sunday(s): ")
    newPayslip.comForPeriod = readNextDouble("Please enter commissions gained for this pay period (0 for none): ")

    // Save the payslip
    appController.addPayslip(newPayslip)

    println("\n=== Payslip Created Successfully! ===")
    println(payslipController.printPayslip(employee!!, newPayslip))
}

fun viewAllPayslips() {
    val employeeId = readNextInt("Please enter your Employee ID to view payslips: ")

    val payslips = appController.getPayslipsByEmployeeId(employeeId)

    if (payslips.isEmpty()) {
        println("No payslips found for Employee ID: $employeeId")
        return
    }

    // Get employee info from the payslips (they all belong to the same employee ID)
    val employeeInfo = payslips.first().employee

    println("\n=== All Payslips for ${employeeInfo.name} (ID: $employeeId) ===")
    payslips.forEachIndexed { index, payslip ->
        println("\n--- Payslip #${index + 1} ---")
        println(payslipController.printPayslip(payslip.employee, payslip))
    }

    println("\nTotal payslips: ${payslips.size}")
}

fun exit() {
    println("Exiting! Thank you for using Payslip Pal.")
    kotlin.system.exitProcess(0)
}