package com.payments.appbase.utils_base

interface BaseConstants {


    interface SharedKey {
        companion object {
            const val DATA_STORE_NAME = "sharepref_data"
            const val USER_DATA = "userData"
            const val TOKEN = "token"
            const val FCM_TOKEN = "fcmToken"
            const val ON_BOARDING_VIEWED = "onBoardingViewed"
            const val IS_CUSTOMER = "isCustomer"
        }
    }

    interface BaseKeys {
        companion object {
            const val SHOW_LOADER = "showLoader"
            const val SHOW_LOADER_MESSAGE = "showLoaderMessage"
            const val HIDE_LOADER = "hideLoader"
            const val SHOW_MESSAGE = "showMessage"
            const val APP = "com.payments.b2b"
        }
    }

    interface Header {
        companion object {
            const val AUTHORIZATION = "Authorization"
        }
    }

    interface ErrorCode {
        companion object {
            const val BAD_REQUEST = 400
            const val UNAUTHORIZED = 401
            const val FORBIDDEN = 403
            const val NOT_FOUND = 404
            const val INTERNAL_SERVER_ERROR = 500
            const val SERVICE_UNAVAILABLE = 503
            const val GATEWAY_TIMEOUT = 504
            const val HTTP_VERSION_NOT_SUPPORTED = 503
            const val SOMETHING_WENT_WRONG = 505

        }
    }

    interface SuccessCode {
        companion object {
            const val SUCCESS = 200
            const val ACCEPTED = 202
        }
    }

    interface SuccessStatus {
        companion object {
            const val TRUE = "TRUE"
            const val SUCCESS = "SUCCESS"
            const val TXN = "TXN"
            const val TXNOTP = "TXNOTP"
            const val TUP = "TUP"
            const val Pending = "Pending"
        }
    }


    interface HttpErrorMessage {
        companion object {

            const val NO_INTERNET = "No internet connection"
            const val INTERNAL_SERVER_ERROR =
                "Our server is under maintenance. We will resolve shortly!"
        }

    }

    interface AuthKey {
        companion object {
            const val AUTH_KEY =
                "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6Miwicm9sZUlkIjozLCJpYXQiOjE2MjgwNTcyMjd9.cdGGIUyWECI_Dq16cbJrHjEJ7wh5GPwktFBgHtbs-6E"
        }
    }
}

