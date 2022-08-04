package com.payments.appbase.network_base

object CheckResponseUtils {

    fun isSuccessfulRequest(status: String): Boolean {
        return status.equals("TRUE", true) ||
                status.equals("SUCCESS", true)||
                status.equals("TXN", true)||
                status.equals("TXNOTP", true)||
                status.equals("TUP", true)||
                status.equals("Pending", true)
    }

}