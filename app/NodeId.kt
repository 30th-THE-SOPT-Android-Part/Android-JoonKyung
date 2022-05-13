
import com.google.gson.annotations.SerializedName

data class NodeId(
    @SerializedName("examples")
    val examples: List<String>,
    @SerializedName("type")
    val type: String
)