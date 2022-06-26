package com.eventbrite.androidchallenge.data.events.model

import okio.*
import java.io.InputStream
import java.nio.ByteBuffer
import java.nio.charset.Charset

class BufferdMock: BufferedSource {
    override fun close() {

    }

    override fun read(sink: ByteArray): Int {
        return 1
    }

    override fun read(sink: ByteArray, offset: Int, byteCount: Int): Int {
        return 1
    }

    override fun read(sink: Buffer, byteCount: Long): Long {
        return 1
    }

    override fun read(p0: ByteBuffer?): Int {
        return 1
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
        return 1
    }

    override fun readShortLe(): Short {
        return 1
    }

    override fun readInt(): Int {
        return 1
    }

    override fun readIntLe(): Int {
        return 1
    }

    override fun readLong(): Long {
        return 1
    }

    override fun readLongLe(): Long {
        return 1
    }

    override fun readDecimalLong(): Long {
        return 1
    }

    override fun readHexadecimalUnsignedLong(): Long {
        return 1
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
        return 1
    }

    override fun readByteArray(): ByteArray {
        return ByteArray(1)
    }

    override fun readByteArray(byteCount: Long): ByteArray {
        return ByteArray(1)
    }

    override fun readFully(sink: ByteArray) {
    }

    override fun readFully(sink: Buffer, byteCount: Long) {
    }

    override fun readAll(sink: Sink): Long {
        return 1
    }

    override fun readUtf8(): String {
        return ""
    }

    override fun readUtf8(byteCount: Long): String {
        return ""
    }

    override fun readUtf8Line(): String? {
        return ""
    }

    override fun readUtf8LineStrict(): String {
        return ""
    }

    override fun readUtf8LineStrict(limit: Long): String {
        return ""
    }

    override fun readUtf8CodePoint(): Int {
        return 1
    }

    override fun readString(charset: Charset): String {
        return ""
    }

    override fun readString(byteCount: Long, charset: Charset): String {
        return ""
    }

    override fun indexOf(b: Byte): Long {
        return 1
    }

    override fun indexOf(b: Byte, fromIndex: Long): Long {
        return 1
    }

    override fun indexOf(b: Byte, fromIndex: Long, toIndex: Long): Long {
        return 1
    }

    override fun indexOf(bytes: ByteString): Long {
        return 1
    }

    override fun indexOf(bytes: ByteString, fromIndex: Long): Long {
        return 1
    }

    override fun indexOfElement(targetBytes: ByteString): Long {
        return 1
    }

    override fun indexOfElement(targetBytes: ByteString, fromIndex: Long): Long {
        return 1
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