package com.example.kitsugithub.base

import com.example.kitsugithub.utils.Resource
import kotlinx.coroutines.flow.flow
import java.io.IOException

abstract class BaseRepository {

    fun <T> doRequest(result: suspend () -> T) = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(result()))
        } catch (exception: IOException) {
            emit(Resource.Error(exception.localizedMessage ?: "Error", null))
        }
    }
}