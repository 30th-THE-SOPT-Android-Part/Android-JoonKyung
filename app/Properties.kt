
import com.google.gson.annotations.SerializedName

data class Properties(
    @SerializedName("avatar_url")
    val avatarUrl: AvatarUrl,
    @SerializedName("email")
    val email: Email,
    @SerializedName("events_url")
    val eventsUrl: EventsUrl,
    @SerializedName("followers_url")
    val followersUrl: FollowersUrl,
    @SerializedName("following_url")
    val followingUrl: FollowingUrl,
    @SerializedName("gists_url")
    val gistsUrl: GistsUrl,
    @SerializedName("gravatar_id")
    val gravatarId: GravatarId,
    @SerializedName("html_url")
    val htmlUrl: HtmlUrl,
    @SerializedName("id")
    val id: Id,
    @SerializedName("login")
    val login: Login,
    @SerializedName("name")
    val name: Name,
    @SerializedName("node_id")
    val nodeId: NodeId,
    @SerializedName("organizations_url")
    val organizationsUrl: OrganizationsUrl,
    @SerializedName("received_events_url")
    val receivedEventsUrl: ReceivedEventsUrl,
    @SerializedName("repos_url")
    val reposUrl: ReposUrl,
    @SerializedName("site_admin")
    val siteAdmin: SiteAdmin,
    @SerializedName("starred_at")
    val starredAt: StarredAt,
    @SerializedName("starred_url")
    val starredUrl: StarredUrl,
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: SubscriptionsUrl,
    @SerializedName("type")
    val type: Type,
    @SerializedName("url")
    val url: Url
)