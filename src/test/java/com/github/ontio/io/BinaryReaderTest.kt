package com.github.ontio.io

import com.github.ontio.common.Helper
import org.junit.Test

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.Arrays

import org.junit.Assert.*

class BinaryReaderTest {

    @Test
    @Throws(IOException::class)
    fun readVarBytes() {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val binaryWriter = BinaryWriter(byteArrayOutputStream)
        binaryWriter.writeVarBytes("12".toByteArray())

        val bin = ByteArrayInputStream(byteArrayOutputStream.toByteArray())
        val binaryReader = BinaryReader(bin)
        val res = binaryReader.readVarBytes()
        assertTrue(Arrays.equals(res, "12".toByteArray()))
    }

    @Test
    @Throws(IOException::class)
    fun readVarInt() {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val binaryWriter = BinaryWriter(byteArrayOutputStream)
        binaryWriter.writeVarInt(123)

        val bin = ByteArrayInputStream(byteArrayOutputStream.toByteArray())
        val binaryReader = BinaryReader(bin)
        val res = binaryReader.readVarInt()
        assertEquals(123, res)
    }

    @Test
    @Throws(IOException::class)
    fun readBoolean() {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val binaryWriter = BinaryWriter(byteArrayOutputStream)
        binaryWriter.writeBoolean(true)

        val bin = ByteArrayInputStream(byteArrayOutputStream.toByteArray())
        val binaryReader = BinaryReader(bin)
        val res = binaryReader.readBoolean()
        assertTrue(res)
    }

    @Test
    @Throws(IOException::class)
    fun readByte() {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val binaryWriter = BinaryWriter(byteArrayOutputStream)
        val a: Byte = 'a'.toByte()
        binaryWriter.writeByte(a)

        val bin = ByteArrayInputStream(byteArrayOutputStream.toByteArray())
        val binaryReader = BinaryReader(bin)
        val res = binaryReader.readByte()
        assertEquals(res.toLong(), 'a')
    }
}