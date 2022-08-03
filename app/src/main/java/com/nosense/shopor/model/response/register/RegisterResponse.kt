package com.nosense.shopor.model.response.register

import com.payments.appbase.model_base.BaseResponse

data class RegisterResponse(
    val otp: String

) : BaseResponse(data = null)
