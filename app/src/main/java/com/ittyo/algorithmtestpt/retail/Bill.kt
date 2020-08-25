package com.ittyo.algorithmtestpt.retail

import java.time.LocalDate
import java.time.Period
import kotlin.math.floor

const val LOYALTY_DISCOUNT_RATE  = 0.05
const val PRICE_DISCOUNT_MULTIPLIER = 5.0
const val PRICE_DISCOUNT_DIVIDER = 100

fun payableAmount(items: List<PurchasedItem>, customer: Customer): Double {
    val totalAmount = items.sumByDouble { it.price }

    val nonGroceriesItems = items.filterIsInstance(NonGroceriesItem::class.java)
    val percentageDiscount = percentageDiscount(nonGroceriesItems, customer)
    val priceDiscount = priceDiscount(totalAmount - percentageDiscount)

    return totalAmount - percentageDiscount - priceDiscount
}

private fun percentageDiscount(items: List<NonGroceriesItem>, customer: Customer): Double {
    val discountRate = when {
        customer is WithSpecialDiscount -> customer.specialDiscountRate
        yearsOfJoin(customer) >= 2 -> LOYALTY_DISCOUNT_RATE
        else -> 0.0
    }
    return items.sumByDouble { it.price } * discountRate
}

private fun priceDiscount(totalPrice: Double): Double {
    return floor(totalPrice/ PRICE_DISCOUNT_DIVIDER) * PRICE_DISCOUNT_MULTIPLIER
}

private fun yearsOfJoin(customer: Customer): Int {
    return Period.between(customer.joinDate, LocalDate.now()).years
}

