
import com.google.gson.annotations.SerializedName

data class Login(
    @SerializedName("examples")
    val examples: List<String>,
    @SerializedName("type")
    val type: String
)