
import com.google.gson.annotations.SerializedName

data class Id(
    @SerializedName("examples")
    val examples: List<Int>,
    @SerializedName("type")
    val type: String
)