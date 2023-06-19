package com.example.tp_project.data

import android.util.Log
import com.example.tp_project.data.token.TokenDataSource
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HeaderInterceptor(
	private val tokenDataSource: TokenDataSource
) : Interceptor {

	override fun intercept(chain: Interceptor.Chain): Response = runBlocking {
		val original: Request = chain.request()

		val token = tokenDataSource.get().token
		Log.i("token",token.toString())

		val request: Request = original.newBuilder()
			.header("authorization","Bearer $token")
			.header("content-type","application/json")
			.header("accept","application/json")
			.build()
		chain.proceed(request)
	}
}