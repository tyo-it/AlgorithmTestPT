package com.ittyo.algorithmtestpt.dataStoreAndLoad

import org.junit.Assert.*
import org.junit.Test

class DataStoreTest {

    @Test(expected = IllegalArgumentException::class)
    fun `throw error when array is empty`() {
        val data = emptyArray<Map<String, String>>()
        val text = store(data)
        assertEquals("", text)
    }

    @Test
    fun `store array with one empty map`() {
        val emptyMap: Map<String, String> = HashMap()
        val data = arrayOf(emptyMap)
        val text = store(data)
        assertEquals("", text)
    }

    @Test
    fun `store array with two empty map`() {
        val emptyMap: Map<String, String> = HashMap()
        val data = arrayOf(emptyMap, emptyMap)
        val text = store(data)
        assertEquals("\n", text)
    }

    @Test
    fun `store one array with a map that has one entry`() {
        val map: Map<String, String> = mapOf("key" to "value")
        val data = arrayOf(map)
        val text = store(data)
        assertEquals("key=value", text)
    }

    @Test
    fun `store one array with a map that has one entry with empty key`() {
        val map: Map<String, String> = mapOf("" to "value")
        val data = arrayOf(map)
        val text = store(data)
        assertEquals("=value", text)
    }

    @Test
    fun `store one array with a map that has one entry with empty value`() {
        val map: Map<String, String> = mapOf("key" to "")
        val data = arrayOf(map)
        val text = store(data)
        assertEquals("key=", text)
    }

    @Test
    fun `store one array with a map that has one entry with empty key and value`() {
        val map: Map<String, String> = mapOf("" to "")
        val data = arrayOf(map)
        val text = store(data)
        assertEquals("=", text)
    }

    @Test
    fun `store one array with a map that has two entry`() {
        val map: Map<String, String> = mapOf("key1" to "value1", "key2" to "value2")
        val data = arrayOf(map)
        val text = store(data)
        assertEquals("key1=value1;key2=value2", text)
    }

    @Test
    fun `store two array with a map that has one entry`() {
        val map1: Map<String, String> = mapOf("key1" to "value1")
        val map2: Map<String, String> = mapOf("key2" to "value2")
        val data = arrayOf(map1, map2)
        val text = store(data)
        assertEquals("key1=value1\nkey2=value2", text)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `throw error when key contain newline`() {
        val emptyMap: Map<String, String> = HashMap()
        val nonEmptyMap: Map<String, String> = mapOf("\n" to "value")
        val data = arrayOf(emptyMap, nonEmptyMap)
        val text = store(data)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `throw error when key contain entry separator`() {
        val emptyMap: Map<String, String> = HashMap()
        val nonEmptyMap: Map<String, String> = mapOf(";" to "value")
        val data = arrayOf(emptyMap, nonEmptyMap)
        val text = store(data)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `throw error when key contain =`() {
        val emptyMap: Map<String, String> = HashMap()
        val nonEmptyMap: Map<String, String> = mapOf("=" to "value")
        val data = arrayOf(emptyMap, nonEmptyMap)
        val text = store(data)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `throw error when value contain newline`() {
        val emptyMap: Map<String, String> = HashMap()
        val nonEmptyMap: Map<String, String> = mapOf("key" to "\n")
        val data = arrayOf(emptyMap, nonEmptyMap)
        val text = store(data)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `throw error when value contain entry separator`() {
        val emptyMap: Map<String, String> = HashMap()
        val nonEmptyMap: Map<String, String> = mapOf("key" to ";")
        val data = arrayOf(emptyMap, nonEmptyMap)
        val text = store(data)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `throw error when value contain =`() {
        val emptyMap: Map<String, String> = HashMap()
        val nonEmptyMap: Map<String, String> = mapOf("key" to "=")
        val data = arrayOf(emptyMap, nonEmptyMap)
        val text = store(data)
    }
}