package com.ittyo.algorithmtestpt.retail

import org.junit.Assert
import org.junit.Test
import java.time.LocalDate

class NonGroceriesWithPriceDiscount {

    @Test
    fun `get $65 discount if purchase is $200 non-groceries only, for Employee`() {
        val user = Employee(LocalDate.now())
        val item = NonGroceriesItem(200.0)
        val bill = Bill(listOf(item))
        val amount = payableAmount(bill, user)
        Assert.assertEquals(135.0, amount, 0.0)
    }

    @Test
    fun `get $25 discount if purchase is $200 non-groceries only, for Affiliate`() {
        val user = Affiliate(LocalDate.now())
        val item = NonGroceriesItem(200.0)
        val bill = Bill(listOf(item))
        val amount = payableAmount(bill, user)
        Assert.assertEquals(175.0, amount, 0.0)
    }

    @Test
    fun `get $15 discount if purchase is $200 non-groceries only, for CommonCustomer joining 2 years`() {
        val joinDate = LocalDate.now().minusYears(2)
        val user = CommonCustomer(joinDate)
        val item = NonGroceriesItem(200.0)
        val bill = Bill(listOf(item))
        val amount = payableAmount(bill, user)
        Assert.assertEquals(185.0, amount, 0.0)
    }
}