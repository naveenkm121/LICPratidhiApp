package com.ecommerce.app.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map

import kotlinx.coroutines.Dispatchers

/*
fun <T, A> performGetOperation(databaseQuery: () -> LiveData<T>,
                               networkCall: suspend () -> ResourceViewState<A>,
                               saveCallResult: suspend (A) -> Unit): LiveData<ResourceViewState<T>> =
    liveData(Dispatchers.IO) {
        emit(ResourceViewState.loading())
        val source = databaseQuery.invoke().map { ResourceViewState.success(it) }
        emitSource(source)

        val responseStatus = networkCall.invoke()
        if (responseStatus.status == Status.SUCCESS) {
            saveCallResult(responseStatus.data!!)

        } else if (responseStatus.status == Status.ERROR) {
            emit(ResourceViewState.error(responseStatus.message!!))
            emitSource(source)
        }
    }

fun <T, A> performGetOperation(databaseQuery: () -> LiveData<T>,
                               networkCall: suspend () -> ResourceViewState<A>,
                               saveCallResult: suspend (A) -> Unit,
clearTable:suspend()->Unit
                               ): LiveData<ResourceViewState<T>> =
    liveData(Dispatchers.IO)
    {
        emit(ResourceViewState.loading())
        val source = databaseQuery.invoke().map { ResourceViewState.success(it) }
        emitSource(source)

        val responseStatus = networkCall.invoke()
        if (responseStatus.status == Status.SUCCESS) {
            clearTable()
            saveCallResult(responseStatus.data!!)

        } else if (responseStatus.status == Status.ERROR) {
            emit(ResourceViewState.error(responseStatus.message!!))
            emitSource(source)
        }
    }
*/

fun <T> performGetOperation(networkCall: suspend () -> ResourceViewState<T>): LiveData<ResourceViewState<T>> =
    liveData(Dispatchers.IO) {
        emit(ResourceViewState.loading())
        val responseStatus= networkCall.invoke()
        if (responseStatus.status == ResourceViewState.Status.SUCCESS) {
            //saveCallResult(responseStatus.data!!)
            emit(ResourceViewState.success(responseStatus.data!!))
          //  emitSource(Resource.success(responseStatus))
        } else if (responseStatus.status == ResourceViewState.Status.ERROR) {
            emit(ResourceViewState.error(responseStatus.message!!))
          //  emitSource(source)
        }
    }