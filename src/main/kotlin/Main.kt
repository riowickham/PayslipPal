import utils.readNextDouble
import utils.readNextInt
import utils.readNextDouble
import utils.readNextLine


fun main() {
    val name = readNextLine("Please enter your name: ")

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
    hourlyPay = readNextDouble("What is your hourly pay?: ")
}

fun logSundayPay(){
    sundayPay = readNextDouble("What is your pay for Sundays?: ")
}

fun commissionsTool(){
    comForPeriod = readNextDouble("Please enter commissions gained for this pay period (0 for none): ")
}

fun logHours(){
    normalHours = readNextDouble("Please enter your hours worked for this period(excluding breaks): ")
    sundayHours = readNextDouble("Please enter your hours worked for Sunday(s): ")
}

fun paymentFrequency() {
    payFreq = readNextInt("Do you get paid (1) Weekly, (2) Biweekly, (3) Monthly:")
}


    val periods = when (payFreq) {
        1 -> 52
        2 -> 26
        3 -> 12
        else -> {
            println("Invalid frequency selected.")
        }
    }

fun taxForPeriod() {
    var yearlyPay = payFreq * ((hourlyPay * normalHours) + (sundayPay * sundayHours))


}

fun printPayslip(){
    print("""
        > ---------------------------
        > |       Payslip           |
        > ---------------------------
        > | $name                         |
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