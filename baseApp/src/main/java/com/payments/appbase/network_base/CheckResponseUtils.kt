package com.payments.appbase.network_base

import com.payments.appbase.utils_base.BaseConstants

object CheckResponseUtils {

    fun isSuccessfulRequest(status: String): Boolean {
        return status.equals(BaseConstants.SuccessStatus.TRUE, true) ||
                status.equals(BaseConstants.SuccessStatus.SUCCESS, true) ||
                status.equals(BaseConstants.SuccessStatus.TXN, true) ||
                status.equals(BaseConstants.SuccessStatus.TXNOTP, true) ||
                status.equals(BaseConstants.SuccessStatus.TUP, true) ||
                status.equals(BaseConstants.SuccessStatus.Pending, true)
    }

    fun isErrorMessage(statusCode: Int): String {
        val message = when (statusCode) {
            BaseConstants.ErrorCode.BAD_REQUEST -> "Bad Request"
            BaseConstants.ErrorCode.UNAUTHORIZED -> "Unauthorized"
            BaseConstants.ErrorCode.FORBIDDEN -> "Forbidden"
            BaseConstants.ErrorCode.NOT_FOUND -> "Not Found"
            BaseConstants.ErrorCode.INTERNAL_SERVER_ERROR -> "Internal Server Error"
            BaseConstants.ErrorCode.SERVICE_UNAVAILABLE -> "Service Unavailable"
            BaseConstants.ErrorCode.GATEWAY_TIMEOUT -> "Gateway Timeout"
            BaseConstants.ErrorCode.HTTP_VERSION_NOT_SUPPORTED -> "HTTP Version Not Supported"
            else -> "Something went wrong"

        }

        return message
    }

}