
import com.google.gson.annotations.SerializedName

data class GravatarId(
    @SerializedName("examples")
    val examples: List<String>,
    @SerializedName("type")
    val type: List<String>
)