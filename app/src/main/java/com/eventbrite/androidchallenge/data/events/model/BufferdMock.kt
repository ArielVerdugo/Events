package com.eventbrite.androidchallenge.data.events.model

import com.eventbrite.androidchallenge.utils.Constants
import okio.*
import java.io.InputStream
import java.nio.ByteBuffer
import java.nio.charset.Charset

class BufferdMock: BufferedSource {
    override fun close() {

    }

    override fun read(sink: ByteArray): Int {
        return Constants.INT_MOCK_VALUE
    }

    override fun read(sink: ByteArray, offset: Int, byteCount: Int): Int {
        return Constants.INT_MOCK_VALUE
    }

    override fun read(sink: Buffer, byteCount: Long): Long {
        return Constants.INT_MOCK_VALUE.toLong()
    }

    override fun read(p0: ByteBuffer?): Int {
        return Constants.INT_MOCK_VALUE
    }

    override fun timeout(): Timeout {
        return Timeout()
    }

    override fun isOpen(): Boolean {
        return true
    }

    override fun buffer(): Buffer {
        return Buffer()
    }

    override fun getBuffer(): Buffer {
        return Buffer()
    }

    override fun exhausted(): Boolean {
        return true
    }

    override fun require(byteCount: Long) {
    }

    override fun request(byteCount: Long): Boolean {
        return true
    }

    override fun readByte(): Byte {
        return Byte.MAX_VALUE
    }

    override fun readShort(): Short {
        return Constants.INT_MOCK_VALUE.toShort()
    }

    override fun readShortLe(): Short {
        return Constants.INT_MOCK_VALUE.toShort()
    }

    override fun readInt(): Int {
        return Constants.INT_MOCK_VALUE
    }

    override fun readIntLe(): Int {
        return Constants.INT_MOCK_VALUE
    }

    override fun readLong(): Long {
        return Constants.INT_MOCK_VALUE.toLong()
    }

    override fun readLongLe(): Long {
        return Constants.INT_MOCK_VALUE.toLong()
    }

    override fun readDecimalLong(): Long {
        return Constants.INT_MOCK_VALUE.toLong()
    }

    override fun readHexadecimalUnsignedLong(): Long {
        return Constants.INT_MOCK_VALUE.toLong()
    }

    override fun skip(byteCount: Long) {

    }

    override fun readByteString(): ByteString {
        return ByteString.EMPTY
    }

    override fun readByteString(byteCount: Long): ByteString {
        return ByteString.EMPTY
    }

    override fun select(options: Options): Int {
        return Constants.INT_MOCK_VALUE
    }

    override fun readByteArray(): ByteArray {
        return ByteArray(Constants.INT_MOCK_VALUE)
    }

    override fun readByteArray(byteCount: Long): ByteArray {
        return ByteArray(Constants.INT_MOCK_VALUE)
    }

    override fun readFully(sink: ByteArray) {
    }

    override fun readFully(sink: Buffer, byteCount: Long) {
    }

    override fun readAll(sink: Sink): Long {
        return Constants.INT_MOCK_VALUE.toLong()
    }

    override fun readUtf8(): String {
        return Constants.STRING_MOCK_VALUE
    }

    override fun readUtf8(byteCount: Long): String {
        return Constants.STRING_MOCK_VALUE
    }

    override fun readUtf8Line(): String? {
        return Constants.STRING_MOCK_VALUE
    }

    override fun readUtf8LineStrict(): String {
        return Constants.STRING_MOCK_VALUE
    }

    override fun readUtf8LineStrict(limit: Long): String {
        return Constants.STRING_MOCK_VALUE
    }

    override fun readUtf8CodePoint(): Int {
        return Constants.INT_MOCK_VALUE
    }

    override fun readString(charset: Charset): String {
        return Constants.STRING_MOCK_VALUE
    }

    override fun readString(byteCount: Long, charset: Charset): String {
        return Constants.STRING_MOCK_VALUE
    }

    override fun indexOf(b: Byte): Long {
        return Constants.INT_MOCK_VALUE.toLong()
    }

    override fun indexOf(b: Byte, fromIndex: Long): Long {
        return Constants.INT_MOCK_VALUE.toLong()
    }

    override fun indexOf(b: Byte, fromIndex: Long, toIndex: Long): Long {
        return Constants.INT_MOCK_VALUE.toLong()
    }

    override fun indexOf(bytes: ByteString): Long {
        return Constants.INT_MOCK_VALUE.toLong()
    }

    override fun indexOf(bytes: ByteString, fromIndex: Long): Long {
        return Constants.INT_MOCK_VALUE.toLong()
    }

    override fun indexOfElement(targetBytes: ByteString): Long {
        return Constants.INT_MOCK_VALUE.toLong()
    }

    override fun indexOfElement(targetBytes: ByteString, fromIndex: Long): Long {
        return Constants.INT_MOCK_VALUE.toLong()
    }

    override fun rangeEquals(offset: Long, bytes: ByteString): Boolean {
        return true
    }

    override fun rangeEquals(
        offset: Long,
        bytes: ByteString,
        bytesOffset: Int,
        byteCount: Int
    ): Boolean {
        return false
    }

    override fun peek(): BufferedSource {
        return BufferdMock()
    }

    override fun inputStream(): InputStream {
        return InputStreamMock()
    }
}