package com.ittyo.algorithmtestpt.retail

sealed class PurchasedItem(val price: Double)
class GroceriesItem(price: Double): PurchasedItem(price)
class NonGroceriesItem(price: Double): PurchasedItem(price)