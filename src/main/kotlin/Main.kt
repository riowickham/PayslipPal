import controllers.PayslipController
import utils.readNextDouble
import utils.readNextInt
import utils.readNextLine

private val psController = PayslipController()

fun main(custName: custName) {
    val custName = readNextLine("Please enter your name: ")

    runMenu()
}

fun mainMenu(): Int {
    print("""
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
        >""".trimMargin(">"))
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
    val hourlyPay = readNextDouble("What is your hourly pay?: ")
}

fun logSundayPay(){
    val sundayPay = readNextDouble("What is your pay for Sundays?: ")
}

fun commissionsTool(){
    val comForPeriod = readNextDouble("Please enter commissions gained for this pay period (0 for none): ")
}

fun logHours(){
    val normalHours = readNextDouble("Please enter your hours worked for this period(excluding breaks): ")
    val sundayHours = readNextDouble("Please enter your hours worked for Sunday(s): ")
}

fun paymentFrequency() {
    val payFreq = readNextInt("Do you get paid (1) Weekly, (2) Biweekly, (3) Monthly:")
}

fun printPayslip(){
    print("""
        > ---------------------------
        > |       Payslip           |
        > ---------------------------
        > | $custName                           |
        > | Weekday Hours worked: $normalHours  |   Pay: ${normalHours * hourlyPay}                      |
        > | Sunday Hours worked: $sundayHours   |   Sunday Pay: ${sundayHours * sundayPay}                     |
        > |                         |
        > | Taxes                        |
        > |                         |
        > ---------------------------
        > |   0) Exit               | 
        > ---------------------------
        >""".trimMargin(">"))
}

fun exit() {
    println("Exiting!")
    exit()
}