import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RocketLaunch(
    @SerialName("flight_number")
    val flightNumber : Int,
    @SerialName("name")
    val missionName: String,
    @SerialName("data_utc")
    val launchDataUTC: String,
    @SerialName("success")
    val isLaunchSuccess: Boolean?,
)