import com.payments.appbase.network_base.NetworkUtils
import com.payments.appbase.utils_base.Print
object BaseMapping {
    fun getBaseUrl(networkUtils: NetworkUtils): String {
        return when (networkUtils) {
            NetworkUtils.BASE_URL -> "http://192.168.29.241:8000/api/"
//            NetworkUtils.BASE_URL -> "http://192.168.210.37:8000/api/"
            else -> ""
        }
    }

}

