package com.ittyo.algorithmtestpt.retail

import org.junit.Assert
import org.junit.Test
import java.time.LocalDate

class NonGroceriesWithNoPriceDiscount {

    @Test
    fun `get 30% discount for employee, non-groceries item`() {
        val user = Employee(LocalDate.now())
        val item = NonGroceriesItem(90.0)
        val bill = Bill(listOf(item))
        val amount = payableAmount(bill, user)
        Assert.assertEquals(63.0, amount, 0.0)
    }

    @Test
    fun `get 10% discount for affiliate, non-groceries item`() {
        val user = Affiliate(LocalDate.now())
        val item = NonGroceriesItem(90.0)
        val bill = Bill(listOf(item))
        val amount = payableAmount(bill, user)
        Assert.assertEquals(81.0, amount, 0.0)
    }

    @Test
    fun `5% discount for common customer joining at least 2 years`() {
        val joinDate = LocalDate.now().minusYears(2)
        val user = CommonCustomer(joinDate)
        val item = NonGroceriesItem(90.0)
        val bill = Bill(listOf(item))
        val amount = payableAmount(bill, user)
        Assert.assertEquals(85.5, amount, 0.0)
    }

    @Test
    fun `no discount for common customer joining less than 2 years`() {
        val joinDate = LocalDate.now().minusYears(2).plusDays(1)
        val user = CommonCustomer(joinDate)
        val item = NonGroceriesItem(90.0)
        val bill = Bill(listOf(item))
        val amount = payableAmount(bill, user)
        Assert.assertEquals(90.0, amount, 0.0)
    }
}