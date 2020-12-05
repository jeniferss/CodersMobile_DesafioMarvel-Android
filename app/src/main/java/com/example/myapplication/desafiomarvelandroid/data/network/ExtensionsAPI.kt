package com.example.myapplication.desafiomarvelandroid.data.network

import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest

class ExtensionsAPI : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val ts = System.currentTimeMillis().toString()
        val apikey = PUBLIC_KEY

        var request = chain.request()
        val originalHttpUrl = request.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter(TS, ts)
            .addQueryParameter(API_KEY, apikey)
            .addQueryParameter(HASH, getHash(ts))
            .build()

        val requestBuilder = request.newBuilder().url(url)
        request = requestBuilder.build()
        return chain.proceed(request)
    }

    private fun getHash(ts: String) = "${ts}$PRIVATE_KEY$PUBLIC_KEY".md5

    private val String.md5: String
        get() {
            val bytes = MessageDigest.getInstance("MD5").digest(this.toByteArray())
            return bytes.joinToString("") {
                "%02x".format(it)
            }
        }

    companion object {
        private const val TS = "ts"
        private const val API_KEY = "apikey"
        private const val HASH = "hash"

        private const val PRIVATE_KEY = "7376c89ad8fe91725aef0b497a9953f744fe17e8"
        private const val PUBLIC_KEY = "7d90a27844a682faf5f6aa601376b0ba"

        fun String.md5(): String {
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
        }
    }

}
