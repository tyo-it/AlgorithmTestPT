package com.ittyo.algorithmtestpt.dataStoreAndLoad

import java.lang.IllegalStateException

fun load(text: String) = loadMapArray(text)

private fun loadMapArray(text: String): Array<Map<String, String>> {
    val result = arrayListOf<Map<String, String>>()
    val itemsText = text.split(ITEM_SEPARATOR)
    for (itemText in itemsText) {
        if (itemText.isEmpty()) {
            result.add(emptyMap())
        } else {
            val map = loadMap(itemText)
            result.add(map)
        }
    }
    return result.toTypedArray()
}

private fun loadMap(text: String): Map<String, String> {
    val result = HashMap<String, String>()
    val entriesText = text.split(ENTRY_SEPARATOR)
    for (entryText in entriesText) {
        val (key, value) = loadEntry(entryText)
        result[key] = value
    }
    return result
}

private fun loadEntry(text: String): Map.Entry<String, String> {
    val items = text.split(KEY_VALUE_SEPARATOR)
    if (items.size == 2) {
        return object: Map.Entry<String, String> {
            override val key: String = items[0]
            override val value: String = items[1]
        }
    } else {
        throw IllegalStateException("data is corrupt")
    }
}