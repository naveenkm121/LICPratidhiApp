package com.ecommerce.app.utils


data class ResourceViewState<out T>(val status: Status, val data: T?, val message: String?,val requestType: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

   /* companion object {
        fun <T> success(data: T?,requestType: String?): ResourceViewState<T> {
            return ResourceViewState(Status.SUCCESS, data, null,requestType)
        }
        fun <T> error(msg: String): ResourceViewState<T> {
            return ResourceViewState(Status.ERROR, null, msg,null)
        }
        fun <T> loading(): ResourceViewState<T> {
            return ResourceViewState(Status.LOADING, null, null,null)
        }
    }*/
   companion object {
       fun <T> success(data: T?, requestType: String?): ResourceViewState<T> {
           return ResourceViewState(Status.SUCCESS, data, null, requestType)
       }
       fun <T> error(msg: String, requestType: String?): ResourceViewState<T> {
           return ResourceViewState(Status.ERROR, null, msg, requestType)
       }
       fun <T> loading(requestType: String?): ResourceViewState<T> {
           return ResourceViewState(Status.LOADING, null, null, requestType)
       }
   }
}