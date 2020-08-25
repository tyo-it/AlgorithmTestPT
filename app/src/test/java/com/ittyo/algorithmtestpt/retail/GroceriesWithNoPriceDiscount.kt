package com.ittyo.algorithmtestpt.retail

import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDate

class GroceriesWithNoPriceDiscount {

    @Test
    fun `no special discount for groceries item, Employee`() {
        val user = Employee(LocalDate.now())
        val item = GroceriesItem(90.0)
        val bill = Bill(listOf(item))
        val amount = payableAmount(bill, user)
        assertEquals(90.0, amount, 0.0)
    }

    @Test
    fun `no special discount for groceries item, Affiliate`() {
        val user = Affiliate(LocalDate.now())
        val item = GroceriesItem(90.0)
        val bill = Bill(listOf(item))
        val amount = payableAmount(bill, user)
        assertEquals(90.0, amount, 0.0)
    }

    @Test
    fun `no loyalty discount for groceries item, CommonCustomer joining 2 years`() {
        val joinDate = LocalDate.now().minusYears(2)
        val user = CommonCustomer(joinDate)
        val item = GroceriesItem(90.0)
        val bill = Bill(listOf(item))
        val amount = payableAmount(bill, user)
        assertEquals(90.0, amount, 0.0)
    }
}