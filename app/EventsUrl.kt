
import com.google.gson.annotations.SerializedName

data class EventsUrl(
    @SerializedName("examples")
    val examples: List<String>,
    @SerializedName("type")
    val type: String
)