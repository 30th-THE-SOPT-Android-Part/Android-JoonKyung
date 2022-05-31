
import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("description")
    val description: String,
    @SerializedName("properties")
    val properties: Properties,
    @SerializedName("required")
    val required: List<String>,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String
)