package controllers

import models.Employee
import models.Payslip
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class PayslipControllerTest {

    private var johnSmithE: Employee? = null
    private var janeDoeE: Employee? = null
    private var jackSmithE: Employee? = null
    private var ellenKellerE: Employee? = null
    private var johnSmithP: Payslip? = null
    private var janeDoeP: Payslip? = null
    private var jackSmithP: Payslip? = null
    private var ellenKellerP: Payslip? = null
    private var populatedPayslips: PayslipController? = PayslipController()
    private var emptyPayslips: PayslipController? = PayslipController()

    @BeforeEach
    fun setup() {
        johnSmithE = Employee("John Smith", 1312, 2, 22.0, 35.0, 20.0)
        janeDoeE = Employee("Jane Doe", 1111, 1, 23.0, 38.0, 20.0)
        jackSmithE = Employee("Jack Smith", 1100, 3, 12.0, 13.0, 10.0)
        ellenKellerE = Employee("Ellen Keller", 1001, 2, 20.0, 30.0, 28.0)

        johnSmithP = Payslip(1312, johnSmithE!!)
        janeDoeP = Payslip(1111, janeDoeE!!)
        jackSmithP = Payslip(1100, jackSmithE!!)
        ellenKellerP = Payslip(1001, ellenKellerE!!)

        populatedPayslips!!.add(johnSmithP!!)
        populatedPayslips!!.add(janeDoeP!!)
        populatedPayslips!!.add(jackSmithP!!)
        populatedPayslips!!.add(ellenKellerP!!)
    }

    @AfterEach
    fun tearDown() {
        johnSmithE = null
        janeDoeE = null
        jackSmithE = null
        ellenKellerE = null
        johnSmithP = null
        janeDoeP = null
        jackSmithP = null
        ellenKellerP = null
        populatedPayslips = null
        emptyPayslips = null
    }

    @Nested
    inner class AddPayslips {
        @Test
        fun `adding John Smith payslip to empty list works`() {
            assertEquals(0, emptyPayslips!!.numberOfPayslips())
            assertTrue(emptyPayslips!!.add(johnSmithP!!))
            assertEquals(1, emptyPayslips!!.numberOfPayslips())
            assertEquals(johnSmithP, emptyPayslips!!.findPayslip(0))
        }

        @Test
        fun `adding Jane Doe payslip to empty list works`() {
            assertEquals(0, emptyPayslips!!.numberOfPayslips())
            assertTrue(emptyPayslips!!.add(janeDoeP!!))
            assertEquals(1, emptyPayslips!!.numberOfPayslips())
            assertEquals(janeDoeP, emptyPayslips!!.findPayslip(0))
        }

        @Test
        fun `adding Jack Smith payslip to empty list works`() {
            assertEquals(0, emptyPayslips!!.numberOfPayslips())
            assertTrue(emptyPayslips!!.add(jackSmithP!!))
            assertEquals(1, emptyPayslips!!.numberOfPayslips())
            assertEquals(jackSmithP, emptyPayslips!!.findPayslip(0))
        }

        @Test
        fun `adding Ellen Keller payslip to empty list works`() {
            assertEquals(0, emptyPayslips!!.numberOfPayslips())
            assertTrue(emptyPayslips!!.add(ellenKellerP!!))
            assertEquals(1, emptyPayslips!!.numberOfPayslips())
            assertEquals(ellenKellerP, emptyPayslips!!.findPayslip(0))
        }
    }

    @Nested
    inner class ListPayslips {
        @Test
        fun `listAllPayslips returns No Payslips Stored when empty`() {
            assertEquals(0, emptyPayslips!!.numberOfPayslips())
            assertTrue(emptyPayslips!!.listAllPayslips().lowercase().contains("no payslips"))
        }

        @Test
        fun `listAllPayslips returns all payslips when populated`() {
            assertEquals(4, populatedPayslips!!.numberOfPayslips())
            val payslipsString = populatedPayslips!!.listAllPayslips().lowercase()
            assertTrue(payslipsString.contains("John Smith"))
            assertTrue(payslipsString.contains("Jane Doe"))
            assertTrue(payslipsString.contains("Jack smith"))
            assertTrue(payslipsString.contains("Ellen Keller"))
        }
    }
}
