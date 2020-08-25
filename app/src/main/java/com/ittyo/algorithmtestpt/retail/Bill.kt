package com.ittyo.algorithmtestpt.retail

import java.time.LocalDate
import java.time.Period

class Bill(val items: List<PurchasedItem>)

const val LOYALTY_DISCOUNT_RATE  = 0.05
const val PRICE_DISCOUNT_MULTIPLIER = 5.0
const val PRICE_DISCOUNT_DIVIDER = 100

fun payableAmount(bill: Bill, customer: Customer): Double {
    val totalAmount = bill.items.sumByDouble { it.price }

    val nonGroceries = bill.items.filterIsInstance(NonGroceriesItem::class.java)
    val percentageDiscount = percentageDiscount(nonGroceries, customer)
    val priceDiscount = priceDiscount(totalAmount - percentageDiscount)

    return totalAmount - percentageDiscount - priceDiscount;
}


fun percentageDiscount(items: List<NonGroceriesItem>, customer: Customer): Double {
    val discountRate = when {
        customer is WithSpecialDiscount -> customer.specialDiscountRate
        yearsOfJoin(customer) >= 2 -> LOYALTY_DISCOUNT_RATE
        else -> 0.0
    }
    return items.sumByDouble { it.price } * discountRate
}

fun priceDiscount(totalPrice: Double): Double {
    return (totalPrice/ PRICE_DISCOUNT_DIVIDER).toInt() * PRICE_DISCOUNT_MULTIPLIER
}

fun yearsOfJoin(customer: Customer): Int {
    return Period.between(customer.joinDate, LocalDate.now()).years
}

