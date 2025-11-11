import utils.readNextInt

fun main() {
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
        > ---------------------------
        > |   5) Print Slip         |
        > ---------------------------
        > |   0) Exit               |
        > ---------------------------
        >""".trimMargin(">"))
    return readNextInt(" > ==>>")
}