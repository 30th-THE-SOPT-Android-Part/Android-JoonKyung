
import com.google.gson.annotations.SerializedName

data class Email(
    @SerializedName("type")
    val type: List<String>
)