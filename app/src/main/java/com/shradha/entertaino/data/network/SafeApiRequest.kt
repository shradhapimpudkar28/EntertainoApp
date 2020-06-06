package com.shradha.entertaino.data.network

import com.shradha.entertaino.utils.ApiException
import retrofit2.Response

abstract class SafeApiRequest {

    suspend fun <T : Any> makeApiRequest(work: suspend () -> Response<T>): T {

        val response = work.invoke()

        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw ApiException(
                response.code().toString()
            )
        }
    }
}

