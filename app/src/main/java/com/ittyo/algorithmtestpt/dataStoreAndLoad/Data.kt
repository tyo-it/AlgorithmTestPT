package com.ittyo.algorithmtestpt.dataStoreAndLoad

import java.lang.IllegalStateException

const val ITEM_SEPARATOR = '\n'
const val ENTRY_SEPARATOR = ';'
const val KEY_VALUE_SEPARATOR = '='

fun store(arrayOfMap: Array<Map<String, String>>) = textOf(arrayOfMap)
fun load(text: String) = loadMapArray(text)

private fun textOf(mapArray: Array<Map<String, String>>): String {
    require(mapArray.isNotEmpty()) { "can't store empty array" }

    val sb = StringBuilder()
    for (map in mapArray) {
        sb.append(textOf(map))
        sb.append(ITEM_SEPARATOR)
    }
    return sb.removeTrailingCharacter().toString()
}

private fun textOf(map: Map<String, String>): String {
    val sb = StringBuilder()
    for (entry in map.entries) {
        sb.append(textOf(entry))
        sb.append(ENTRY_SEPARATOR)
    }
    return sb.removeTrailingCharacter().toString()
}

private fun textOf(entry: Map.Entry<String, String>): String {
    requireNotContainSeparator(entry.key)
    requireNotContainSeparator(entry.value)

    val sb = StringBuilder()
    sb.append(entry.key)
    sb.append(KEY_VALUE_SEPARATOR)
    sb.append(entry.value)
    return sb.toString()
}

fun loadMap(text: String): Map<String, String> {
    val result = HashMap<String, String>()
    val entriesText = text.split(ENTRY_SEPARATOR)
    for (entryText in entriesText) {
        val (key, value) = loadEntry(entryText)
        result[key] = value
    }
    return result
}

fun loadMapArray(text: String): Array<Map<String, String>> {
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

private fun requireNotContainSeparator(text: String) {
    require(!text.contains(ITEM_SEPARATOR)) { "contains new line"}
    require(!text.contains(ENTRY_SEPARATOR)) { "contains $ENTRY_SEPARATOR" }
    require(!text.contains(KEY_VALUE_SEPARATOR)) { "contains $KEY_VALUE_SEPARATOR" }
}

private fun StringBuilder.removeTrailingCharacter(): StringBuilder {
    if (length > 0) {
        deleteCharAt(length - 1)
    }
    return this
}