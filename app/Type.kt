
import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("examples")
    val examples: List<String>,
    @SerializedName("type")
    val type: String
)