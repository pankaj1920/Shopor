package com.nosense.shopor.network

import com.payments.appbase.listner_base.BaseRepoListener
import com.payments.appbase.network_base.BaseRetrofitClient
import com.payments.appbase.network_base.NetworkUtils

class RetrofitClient(repoListener: BaseRepoListener?) : BaseRetrofitClient(repoListener) {
    fun getApiService(): ApiService =
        provideRetrofit(provideOkHttpClient(), NetworkUtils.BASE_URL).create(ApiService::class.java)
}