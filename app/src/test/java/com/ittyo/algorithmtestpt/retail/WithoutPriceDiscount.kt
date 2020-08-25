package com.ittyo.algorithmtestpt.retail

import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDate

class WithoutPriceDiscount {

    @Test
    fun `Given Employee purchase groceries items, then there is no discount`() {
        val user = Employee(LocalDate.now())
        val item = GroceriesItem(90.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(90.0, amount, 0.0)
    }

    @Test
    fun `Given Affiliate purchase groceries items, then there is no discount`() {
        val user = Affiliate(LocalDate.now())
        val item = GroceriesItem(90.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(90.0, amount, 0.0)
    }

    @Test
    fun `Given CommonCustomer (2 years joining) purchase groceries item, then there is no discount`() {
        val joinDate = LocalDate.now().minusYears(2)
        val user = CommonCustomer(joinDate)
        val item = GroceriesItem(90.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(90.0, amount, 0.0)
    }

    @Test
    fun `Given CommonCustomer (less 2 years joining) purchase groceries item, then there is no discount`() {
        val joinDate = LocalDate.now().minusYears(2).plusDays(1)
        val user = CommonCustomer(joinDate)
        val item = GroceriesItem(90.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(90.0, amount, 0.0)
    }

    @Test
    fun `Given Employee purchase non-groceries items, then receive 30% discount`() {
        val user = Employee(LocalDate.now())
        val item = NonGroceriesItem(90.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(63.0, amount, 0.0)
    }

    @Test
    fun `Given Affiliate purchase non-groceries items, then receive 10% discount`() {
        val user = Affiliate(LocalDate.now())
        val item = NonGroceriesItem(90.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(81.0, amount, 0.0)
    }

    @Test
    fun `Given CommonCustomer (2 years joining) purchase non-groceries items, then receive 5% discount`() {
        val joinDate = LocalDate.now().minusYears(2)
        val user = CommonCustomer(joinDate)
        val item = NonGroceriesItem(90.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(85.5, amount, 0.0)
    }

    @Test
    fun `Given CommonCustomer (less 2 years joining) purchase non-groceries items, then receive no discount`() {
        val joinDate = LocalDate.now().minusYears(2).plusDays(1)
        val user = CommonCustomer(joinDate)
        val item = NonGroceriesItem(90.0)
        val amount = payableAmount(listOf(item), user)
        assertEquals(90.0, amount, 0.0)
    }
}
