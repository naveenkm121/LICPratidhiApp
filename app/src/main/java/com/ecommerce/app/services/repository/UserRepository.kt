package com.ecommerce.app.services.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.ecommerce.app.services.api.ProductService
import com.ecommerce.app.ui.paging.ProductPagingSource
import javax.inject.Inject


class UserRepository @Inject constructor(private val productService: ProductService) {

/*    fun getProductList() = Pager(
        config = PagingConfig(pageSize = 10, maxSize = 100),
        pagingSourceFactory = { ProductPagingSource(productService) }
    ).liveData*/
}