package com.ecommerce.app.services.remotedata

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.ecommerce.app.constants.RequestApiType
import com.ecommerce.app.data.product.ProductReqParam
import com.ecommerce.app.services.api.ProductService
import com.ecommerce.app.ui.paging.ProductPagingSource
import javax.inject.Inject

class ProductRemoteDataSource @Inject constructor( private  val productService: ProductService) :
    BaseDataSource() {

    suspend fun getLaunchStatus()=getResult ({ productService.getLaunchStatus() },RequestApiType.REQUEST_LAUNCH_STATUS.value)
    suspend fun getProducts()=getResult ({ productService.getProducts() },RequestApiType.REQUEST_GET_PRODUCTS.value)

    suspend fun getProductDetailsById(prodId:Int)=getResult ({ productService.getProductDetailsById(prodId) },RequestApiType.REQUEST_GET_PRODUCT_DETAILS.value)

    //suspend fun getProducts(pageNo:Int)=getResult { productService.getProductsPage(pageNo) }

    fun getProductList(productReqParam: ProductReqParam) = Pager(
        config = PagingConfig(pageSize = 10, maxSize = 100),
        pagingSourceFactory = { ProductPagingSource(productService,productReqParam) }
    ).liveData


    suspend fun getCategories()=getResult ({ productService.getCategories() },RequestApiType.REQUEST_GET_CATEGORIES.value)
}