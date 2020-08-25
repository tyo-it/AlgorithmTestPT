package com.ittyo.algorithmtestpt.retail

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDate

class WithPriceDiscount {
    @Test
    fun `Given Employee purchase $100 groceries items, then get $5 discount`() {
        val user = Employee(LocalDate.now())
        val item = GroceriesItem(100.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(95.0, amount, 0.0)
    }

    @Test
    fun `Given Employee purchase $200 groceries items, then get $10 discount`() {
        val user = Employee(LocalDate.now())
        val item = GroceriesItem(200.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(190.0, amount, 0.0)
    }

    @Test
    fun `Given Affiliate purchase $100 groceries items, then get $5 discount`() {
        val user = Affiliate(LocalDate.now())
        val item = GroceriesItem(100.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(95.0, amount, 0.0)
    }

    @Test
    fun `Given Affiliate purchase $200 groceries items, then get $10 discount`() {
        val user = Affiliate(LocalDate.now())
        val item = GroceriesItem(200.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(190.0, amount, 0.0)
    }

    @Test
    fun `Given CommonCustomer purchase $100 groceries items, then get $5 discount`() {
        val user = CommonCustomer(LocalDate.now())
        val item = GroceriesItem(100.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(95.0, amount, 0.0)
    }

    @Test
    fun `Given CommonCustomer purchase $200 groceries items, then get $10 discount`() {
        val user = CommonCustomer(LocalDate.now())
        val item = GroceriesItem(200.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(190.0, amount, 0.0)
    }

    @Test
    fun `Given Employee purchase $200 non-groceries items, then get $65 discount`() {
        val user = Employee(LocalDate.now())
        val item = NonGroceriesItem(200.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(135.0, amount, 0.0)
    }

    @Test
    fun `Given Affiliate purchase $200 non-groceries items, then get $25 discount`() {
        val user = Affiliate(LocalDate.now())
        val item = NonGroceriesItem(200.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(175.0, amount, 0.0)
    }

    @Test
    fun `Given CommonCustomer (2 years joining) purchase $200 non-groceries items, then get $15 discount`() {
        val joinDate = LocalDate.now().minusYears(2)
        val user = CommonCustomer(joinDate)
        val item = NonGroceriesItem(200.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(185.0, amount, 0.0)
    }

    @Test
    fun `Given CommonCustomer (less 2 years joining) purchase $200 non-groceries items, then get $10 discount`() {
        val joinDate = LocalDate.now().minusYears(2).plusDays(1)
        val user = CommonCustomer(joinDate)
        val item = NonGroceriesItem(200.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(190.0, amount, 0.0)
    }

    @Test
    fun `Given Employee purchase $200 non-groceries items, $100 groceries items, get $70 discount`() {
        val user = Employee(LocalDate.now())
        val nonGroceries = NonGroceriesItem(200.0)
        val groceries = GroceriesItem(100.0)
        val amount = payableAmount(listOf(nonGroceries, groceries), user)
        assertEquals(230.0, amount, 0.0)
    }

    @Test
    fun `Given Affiliate purchase $200 non-groceries items, $100 groceries items, get $30 discount`() {
        val user = Affiliate(LocalDate.now())
        val nonGroceries = NonGroceriesItem(200.0)
        val groceries = GroceriesItem(100.0)
        val amount = payableAmount(listOf(nonGroceries, groceries), user)
        assertEquals(270.0, amount, 0.0)
    }

    @Test
    fun `Given CommonCustomer (2 years joining) purchase $200 non-groceries items, $100 groceries items, get $20 discount`() {
        val joinDate = LocalDate.now().minusYears(2)
        val user = CommonCustomer(joinDate)
        val nonGroceries = NonGroceriesItem(200.0)
        val groceries = GroceriesItem(100.0)
        val amount = payableAmount(listOf(nonGroceries, groceries), user)
        assertEquals(280.0, amount, 0.0)
    }

    @Test
    fun `Given CommonCustomer (less 2 years joining) purchase $200 non-groceries items, $100 groceries items, get $15 discount`() {
        val joinDate = LocalDate.now().minusYears(2).plusDays(1)
        val user = CommonCustomer(joinDate)
        val nonGroceries = NonGroceriesItem(200.0)
        val groceries = GroceriesItem(100.0)
        val amount = payableAmount(listOf(nonGroceries, groceries), user)
        assertEquals(285.0, amount, 0.0)
    }
}
