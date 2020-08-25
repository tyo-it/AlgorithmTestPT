package com.ittyo.algorithmtestpt.retail

import org.junit.Assert
import org.junit.Test
import java.time.LocalDate

class GroceriesWithPriceDiscount {

    @Test
    fun `get $5 discount if purchase is $100 groceries only, for Employee`() {
        val user = Employee(LocalDate.now())
        val item = GroceriesItem(100.0)
        val bill = Bill(listOf(item))
        val amount = payableAmount(bill, user)
        Assert.assertEquals(95.0, amount, 0.0)
    }

    @Test
    fun `get $10 discount if purchase is $200 groceries only, for Employee`() {
        val user = Employee(LocalDate.now())
        val item = GroceriesItem(200.0)
        val bill = Bill(listOf(item))
        val amount = payableAmount(bill, user)
        Assert.assertEquals(190.0, amount, 0.0)
    }

    @Test
    fun `get $5 discount if purchase is $100 groceries only, for Affiliate`() {
        val user = Affiliate(LocalDate.now())
        val item = GroceriesItem(100.0)
        val bill = Bill(listOf(item))
        val amount = payableAmount(bill, user)
        Assert.assertEquals(95.0, amount, 0.0)
    }

    @Test
    fun `get $10 discount if purchase is $200 groceries only, for Affiliate`() {
        val user = Affiliate(LocalDate.now())
        val item = GroceriesItem(200.0)
        val bill = Bill(listOf(item))
        val amount = payableAmount(bill, user)
        Assert.assertEquals(190.0, amount, 0.0)
    }

    @Test
    fun `get $5 discount if purchase is $100 groceries only, for Common Customer`() {
        val user = CommonCustomer(LocalDate.now())
        val item = GroceriesItem(100.0)
        val bill = Bill(listOf(item))
        val amount = payableAmount(bill, user)
        Assert.assertEquals(95.0, amount, 0.0)
    }

    @Test
    fun `get $10 discount if purchase is $200 groceries only, for Common Customer`() {
        val user = CommonCustomer(LocalDate.now())
        val item = GroceriesItem(200.0)
        val bill = Bill(listOf(item))
        val amount = payableAmount(bill, user)
        Assert.assertEquals(190.0, amount, 0.0)
    }
}