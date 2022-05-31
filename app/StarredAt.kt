
import com.google.gson.annotations.SerializedName

data class StarredAt(
    @SerializedName("examples")
    val examples: List<String>,
    @SerializedName("type")
    val type: String
)