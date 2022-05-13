## WEEK 4 ANDROID SEMINAR 4차 과제

### 01 필수 과제

> 1-1 필수과제: 로그인/회원가입 API 연동

- POSTMAN 테스트 + 회원가입 완료 + 로그인 완료 토스트 메시지

![스크린샷(419)](https://user-images.githubusercontent.com/90037701/168191793-45524e96-5b00-4200-b554-94b2bee6ca40.png)
![스크린샷(420)](https://user-images.githubusercontent.com/90037701/168191799-432fcbf4-8cef-474b-8c5f-8bbb9d039219

https://user-images.githubusercontent.com/90037701/168192433-1aceebc0-d01a-4fc1-85d9-0cd6dfd51d67.mp4

- retrafit interface와 구현체 코드, Request / Response 객체에 대한 코드

Request 코드

```kotlin
data class RequestSignIn(
    @SerializedName("email")
    val id: String,
    val password: String
)
```

```kotlin
data class RequestSignUp(
    val name: String,
    @SerializedName("email")
    val id: String,
    val password: String
)
```

Response 코드

```kotlin
data class ResponseSignIn(
    val status: Int,
    val message: String,
    val data: Data
) {
    data class Data(
        val name: String,
        val email: String
    )
}
```

```kotlin
data class ResponseSignUp(
    val status: Int,
    val messages: String,
    val data: SignUpData
)

data class SignUpData(
    val id: Int
)

```

서비스 인터페이스

```kotlin
interface SoptService {

    @POST("auth/signin")
    fun postLogin(
        @Body body: RequestSignIn
    ): Call<ResponseSignIn>


    @POST("auth/signup")
    fun postSignUp(
        @Body body: RequestSignUp
    ): Call<ResponseSignUp>
}
```

레트로핏 구현체

```kotlin
object ServiceCreator {
    private const val BASE_URL = "http://13.124.62.236/"

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val soptService: SoptService = retrofit.create(SoptService::class.java)
}
```

### 02 성장 과제

> 2-1 성장과제: Github API 연동해서 리스트로 띄우기

깃허브 Response 코드

```kotlin
data class ResponseGitHubFollowerItem(
    val avatar_url: String,
    val events_url: String,
    val followers_url: String,
    val following_url: String,
    val gists_url: String,
    val gravatar_id: String,
    val html_url: String,
    val id: Int,
    val login: String,
    val node_id: String,
    val organizations_url: String,
    val received_events_url: String,
    val repos_url: String,
    val site_admin: Boolean,
    val starred_url: String,
    val subscriptions_url: String,
    val type: String,
    val url: String
)
```

깃허브 서비스 인터페이스

```kotlin
interface GitHubService {

    @GET("users/{username}/followers")
    fun getGithubFollower(
        @Path("username") username: String): Call<List<ResponseGitHubFollowerItem>>
}
```

깃허브 레트로핏 구현체

```kotlin
object GitHubCreator {
    private const val BASE_URL = "http://api.github.com/"

    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val gitHubService: GitHubService = retrofit.create(GitHubService::class.java)
}
```

> 2-2 성장과제: 데이터클래스 중복 내용 해결

### 03 도전 과제

> 3-1 도전과제: 비동기 처리 라이브러리를 이용해 서버통신 하기

```kotlin
private fun getRequestWithPathParameters() {
        val retService = RetrofitInstance.getRetrofitInstance().create(GitHubService::class.java)

        val pathResponse: LiveData<Response<List<ResponseGitHubFollowerItem>>> = liveData {
            val response = retService.getGithubFollower("lee989898")
            emit(response)
        }

        pathResponse.observe(viewLifecycleOwner) {
            for (i in 0 until it.body()!!.size) {
                list.add(
                    FollowerData(
                        it.body()?.get(i)?.login.toString(),
                        it.body()?.get(i)?.avatar_url.toString()
                    )
                )
            }

        }
    }
```

### 이번 과제를 통해 배운 내용

## __참고자료__

https://www.baeldung.com/kotlin/data-objects
https://docs.github.com/en/rest/users/followers#list-the-people-a-user-follows
       
