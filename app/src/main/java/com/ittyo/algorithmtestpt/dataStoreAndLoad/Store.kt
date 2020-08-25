package com.ittyo.algorithmtestpt.dataStoreAndLoad

fun store(arrayOfMap: Array<Map<String, String>>) = textOf(arrayOfMap)

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