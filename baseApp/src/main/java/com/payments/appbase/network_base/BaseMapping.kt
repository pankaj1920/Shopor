import com.payments.appbase.network_base.NetworkUtils
import com.payments.appbase.utils_base.Print
object BaseMapping {
    fun getBaseUrl(networkUtils: NetworkUtils): String {
        return when (networkUtils) {
            NetworkUtils.BASE_URL -> "https://finoviti.in/retailer/api/"
            else -> ""
        }
    }

}

