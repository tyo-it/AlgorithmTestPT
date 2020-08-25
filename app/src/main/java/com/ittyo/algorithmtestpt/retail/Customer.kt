package com.ittyo.algorithmtestpt.retail

import java.time.LocalDate

sealed class Customer(val joinDate: LocalDate)

class Employee(joinDate: LocalDate): Customer(joinDate), WithSpecialDiscount {
    override val specialDiscountRate: Double = 0.3
}

class Affiliate(joinDate: LocalDate): Customer(joinDate), WithSpecialDiscount {
    override val specialDiscountRate: Double = 0.1
}

class CommonCustomer(joinDate: LocalDate): Customer(joinDate)