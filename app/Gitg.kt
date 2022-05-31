
import com.google.gson.annotations.SerializedName

data class Gitg(
    @SerializedName("items")
    val items: Items,
    @SerializedName("type")
    val type: String
)