
import com.google.gson.annotations.SerializedName

data class FollowingUrl(
    @SerializedName("examples")
    val examples: List<String>,
    @SerializedName("type")
    val type: String
)