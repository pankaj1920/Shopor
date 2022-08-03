package com.nosense.shopor.network

import com.nosense.shopor.model.request.register.RegisterRequest
import com.nosense.shopor.model.response.register.RegisterResponse
import com.payments.appbase.listner_base.BaseRepoListener
import com.payments.appbase.model_base.State
import com.payments.b2b.app_base.network.NetworkBoundRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class ModelRepository(private val baseRepoListener: BaseRepoListener?) {
    private val apiService = RetrofitClient(baseRepoListener)

    fun register(request: RegisterRequest): Flow<State<RegisterResponse>> {
        return object : NetworkBoundRepository<RegisterResponse>(baseRepoListener) {
            override suspend fun fetchData(): Response<RegisterResponse> {
                return apiService.getApiService().register(request)
            }

        }.asFlow()
    }
}