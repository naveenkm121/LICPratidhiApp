package com.ecommerce.app.utils


data class ResourceViewState<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): ResourceViewState<T> {
            return ResourceViewState(Status.SUCCESS, data, null)
        }
        fun <T> error(msg: String): ResourceViewState<T> {
            return ResourceViewState(Status.ERROR, null, msg)
        }
        fun <T> loading(): ResourceViewState<T> {
            return ResourceViewState(Status.LOADING, null, null)
        }
    }
}