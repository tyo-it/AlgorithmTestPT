package com.ittyo.algorithmtestpt.dataStoreAndLoad

import org.junit.Assert.*
import org.junit.Test

class LoadTest {

    @Test
    fun `load into an array with a map that has one entry`() {
        val text = "key=value"
        val map: Map<String, String> = mapOf("key" to "value")
        val expected = arrayOf(map)
        assertArrayEquals(expected, load(text))
    }

    @Test
    fun `load into an array with a map that has one entry with empty key`() {
        val text = "=value"
        val map: Map<String, String> = mapOf("" to "value")
        val expected = arrayOf(map)
        assertArrayEquals(expected, load(text))
    }

    @Test
    fun `load into an array with a map that has one entry with empty value`() {
        val text = "key="
        val map: Map<String, String> = mapOf("key" to "")
        val expected = arrayOf(map)
        assertArrayEquals(expected, load(text))
    }

    @Test
    fun `load into an array with a map that has one entry with empty key and value`() {
        val text = "="
        val map: Map<String, String> = mapOf("" to "")
        val expected = arrayOf(map)
        assertArrayEquals(expected, load(text))
    }

    @Test(expected = IllegalStateException::class)
    fun `throws exception when format is invalid, no key value separator`() {
        val text = "key1value1"
        load(text)
    }

    @Test
    fun `load into an array with a map that has two entry`() {
        val text = "key1=value1;key2=value2"
        val map: Map<String, String> = mapOf("key1" to "value1", "key2" to "value2")
        val expected = arrayOf(map)
        assertArrayEquals(expected, load(text))
    }

    @Test(expected = IllegalStateException::class)
    fun `throws exception when format is invalid, no entry separator`() {
        val text = "key1=value1key2=value2"
        load(text)
    }

    @Test
    fun `load into an array with two map, each has one entry`() {
        val text = "key1=value1\nkey2=value2"
        val map1: Map<String, String> = mapOf("key1" to "value1")
        val map2: Map<String, String> = mapOf("key2" to "value2")
        val expected = arrayOf(map1, map2)
        assertArrayEquals(expected, load(text))
    }

    @Test(expected = IllegalStateException::class)
    fun `throws exception when format is invalid, no item separator`() {
        val text = "k1=v1;k2=v2 k1=v1;k2=v2"
        load(text)
    }

    @Test(expected = IllegalStateException::class)
    fun `throws exception when format is invalid, entry separator at the end of text`() {
        val text = "k1=v1;k2=v2;"
        load(text)
    }

    @Test
    fun `load into an array with empty map`() {
        val text = ""
        val expected = arrayOf(emptyMap<String, String>())
        assertArrayEquals(expected, load(text))
    }
}