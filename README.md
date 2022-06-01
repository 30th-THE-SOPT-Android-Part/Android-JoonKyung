## WEEK 4 ANDROID SEMINAR 4차 과제

https://user-images.githubusercontent.com/90037701/171320129-0090f29f-f567-421c-a235-9808d5f07e5d.mp4

https://user-images.githubusercontent.com/90037701/171320147-6b6132a1-cb87-46a5-95aa-7f8f0de0081b.mp4

### 01 필수 과제

> 1-1 필수과제: SharedPreferences를 사용해서 자동로그인 / 자동로그인 해제 구현하기

전역으로 쓰이는 SharedPreferences object 클래스 생성

```kotlin
object SharedPreferences {
    private const val STORAGE_KEY = "USER_AUTH"
    private const val AUTO_LOGIN = "AUTO_LOGIN"
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
    }

    fun getAutoLogin(): Boolean {
        return preferences.getBoolean(AUTO_LOGIN, false)
    }

    fun setAutoLogin(value: Boolean) {
        preferences.edit()
            .putBoolean(AUTO_LOGIN, value)
            .apply()
    }

    fun setLogout(context: Context) {
        preferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
        preferences.edit()
            .remove(AUTO_LOGIN)
            .clear()
            .apply()
    }
}
```

자동로그인 함수와 자동로그인 선택하는 함수를 만들어 주었습니다

```kotlin
fun autoLogin() {
    binding.ivAutoLogin.isSelected = !binding.ivAutoLogin.isSelected
    SharedPreferences.setAutoLogin(binding.ivAutoLogin.isSelected)
 }
 private fun isAutoLogin() {
      if (SharedPreferences.getAutoLogin()) {
        showToast("자동로그인 되었습니다")
       startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
   }
}
```

이미지 버튼으로 자동로그인 디자인 해주었습니다

```kotlin
<ImageButton
            android:id="@+id/iv_auto_login"
            app:layout_constraintStart_toEndOf="@+id/sign_in_id_tv"
            app:layout_constraintTop_toTopOf="@id/sign_in_id_tv"
            app:layout_constraintBottom_toBottomOf="@id/sign_in_id_tv"
            android:src="@drawable/selector_auto_login"
            android:layout_marginStart="150dp"
            android:onClick="@{()->signInActivity.autoLogin()}"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>

        <TextView
            app:layout_constraintStart_toEndOf="@id/iv_auto_login"
            app:layout_constraintTop_toTopOf="@id/iv_auto_login"
            app:layout_constraintBottom_toBottomOf="@id/iv_auto_login"
            android:text="자동 로그인"
            android:layout_marginStart="10dp"
            android:fontFamily="@font/noto_sans_kr_regular"
            android:includeFontPadding="false"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>
```

자동 로그인 해제하는 Setting Activiity에서 자동로그인 해제를 누르면 아래 함수가 실행되게 했습니다

```kotlin
    fun autoLoginClear(){
        showToast("자동로그인이 해제되었습니다.")
        SharedPreferences.setLogout(this)
    }
```

### 02 성장 과제

> 2-1 성장과제 온보딩 화면 만들기

온보딩 화면을 보여주는 프래그먼트 3개를 만들어 주었습니다

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>

    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".OnBoardingFirstFragment">

        <ImageView
            android:id="@+id/iv_github_logo"
            android:layout_width="100dp"
            android:layout_height="100dp"
            android:layout_marginTop="100dp"
            android:src="@drawable/github_logo"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="20dp"
            android:fontFamily="@font/noto_sans_kr_bold"
            android:gravity="center"
            android:includeFontPadding="false"
            android:text="GitHub에 오신걸\n환영합니다!"
            android:textColor="@color/purple_500"
            android:textSize="20sp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@id/iv_github_logo" />

        <Button
            android:id="@+id/bt_next"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginHorizontal="20dp"
            android:layout_marginBottom="20dp"
            android:background="@drawable/next_round_button"
            android:fontFamily="@font/noto_sans_kr_bold"
            android:text="다음으로"
            android:textColor="@color/white"
            app:layout_constraintBottom_toBottomOf="parent" />

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```

마지막 3번째 프래그먼트에서 다음 화면으로 넘어가고 finish()를 통해 사라지게 해주었습니다

```kotlin
class OnBoardingThirdFragment :
    BindingFragment<FragmentOnboardingThirdBinding>(R.layout.fragment_onboarding_third) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btNext.setOnClickListener {
            startActivity(Intent(activity, SignInActivity::class.java))
            activity?.finish()
        }
    }
}
```

### 03 도전 과제

> 3-1 도전과제: Room을 사용한 자동로그인 로직 만들기

### 이번 과제를 통해 배운 내용

유용한 sharedPreference와 확장함수에 대해서 배웠습니다
전역으로 써서 코드를 많이 줄일 수 있는게 좋았습니다

## __참고자료__
       
