## WEEK 1 ANDROID SEMINAR 1차 과제

### 01 필수 과제

> 1-1 필수과제: 로그인 페이지 만들기(SignInActivity)

- 아이디, 비밀번호 모두 입력이 되어있을 떄만 로그인 버튼을 눌렀을떄 HomeActivity로 이동("로그인 성공" 이라는 토스트 메시지 출력), 아이디, 비밀번호 둘중 하나라도 비어있다면 "아이디/비밀번호를 확인해주세요" 라는 토스트 메시지 출력)

```kotlin
binding.signInLoginBt.setOnClickListener {
            if (binding.signInIdEt.text.isNullOrBlank() || binding.signInPasswordEt.text.isNullOrBlank()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
```

- 비밀번호 EditTextView 입력 내용 가리기(InputType 속성), 모든 EditTextView는 미리보기 글씨가 있어야 함(hint 속성)

```kotlin
<EditText
        android:id="@+id/sign_in_password_et"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginHorizontal="20dp"
        android:layout_marginTop="10dp"
        android:hint="비밀번호를 입력해주세요."
        android:inputType="textPassword"
        app:layout_constraintTop_toBottomOf="@id/sign_in_password_tv" />
```

- 회원가입 버튼을 클릭시 SignUpActivity로 이동

```kotlin
binding.signInJoinBt.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
```

> 1-2 필수과제: 회원가입 페이지 만들기(SignUpActivity)

- 이름, 아이디, 비밀번호 모두 입력이 되어있을 때만 회원가입 버튼을 눌렀을때 다시 SignInActivity로 이동(이때는 intent가 아닌 finish 활용), 이름, 아이디, 비밀번호 중 하나라도 비어있다면 "입력되지 않은 정보가 있습니다" 라는 토스트 메시지 출력

```kotlin
binding.signUpJoinBt.setOnClickListener {
            if (binding.signUpNameEt.text.isNullOrBlank() || binding.signUpIdEt.text.isNullOrBlank() || binding.signUpPasswordEt.text.isNullOrBlank()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            } else {
                finish()
            }
        }
```

- 비밀번호 EditTextView 입력 내용 가리기(InputType 속성), 모든 EditTextView는 미리보기 글씨가 있어야 함(hint 속성)

```kotlin
<EditText
        android:id="@+id/sign_up_password_et"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginHorizontal="20dp"
        android:layout_marginTop="10dp"
        android:hint="비밀번호를 입력해주세요."
        android:inputType="textPassword"
        app:layout_constraintTop_toBottomOf="@id/sign_up_password_tv" />
```

> 1-3 필수과제: 자기소개 페이지 만들기(HomeActivity)

- ImageView, TextView 활용, 이름, 나이, MBTI 등 자기소개 작성

```kotlin
<ImageView
        android:layout_width="100dp"
        android:id="@+id/home_profile_iv"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:layout_marginTop="50dp"
        android:src="@drawable/profile"
        android:scaleType="fitXY"
        android:layout_height="100dp"/>

    <TextView
        android:id="@+id/home_name_tv"
        app:layout_constraintTop_toBottomOf="@id/home_profile_iv"
        android:layout_width="wrap_content"
        android:layout_marginTop="20dp"
        app:layout_constraintStart_toStartOf="@id/home_profile_iv"
        app:layout_constraintEnd_toEndOf="@id/home_profile_iv"
        android:text="이름: 이준경"
        android:layout_height="wrap_content"/>

    <TextView
        android:id="@+id/home_age_tv"
        app:layout_constraintTop_toBottomOf="@+id/home_name_tv"
        android:layout_width="wrap_content"
        android:layout_marginTop="20dp"
        app:layout_constraintStart_toStartOf="@id/home_name_tv"
        android:text="나이: 27"
        android:layout_height="wrap_content"/>

    <TextView
        android:id="@+id/home_mbti_tv"
        app:layout_constraintTop_toBottomOf="@id/home_age_tv"
        android:layout_width="wrap_content"
        android:layout_marginTop="20dp"
        app:layout_constraintStart_toStartOf="@id/home_age_tv"
        android:text="MBTI: ISTP"
        android:layout_height="wrap_content"/>
```

### 02 성장 과제

> 2-1 성장과제: 화면이동 + @

- 회원가입:SignUpActivity)이 성공한다면 이전 로그인 화면으로 돌아온다, 회원가입 화면에서 로그인화면으로 돌아갈떄 회원가입에서 입력했던 아이디와 비밀번호가 입력되어 있어야 함(Hint : registerForActivityResult, putExtra)

- SignInActivity.kt
```kotlin
val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if(result.resultCode == Activity.RESULT_OK){
                val myData: Intent? = result.data
                binding.signInIdEt.setText(myData!!.getStringExtra("id"))
                binding.signInPasswordEt.setText(result.data?.getStringExtra("pwd"))
            }
        }

binding.signInJoinBt.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }
```

- SingUpActivity.kt
```kotlin
binding.signUpJoinBt.setOnClickListener {
            if (binding.signUpNameEt.text.isNullOrBlank() || binding.signUpIdEt.text.isNullOrBlank() || binding.signUpPasswordEt.text.isNullOrBlank()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("id", binding.signUpIdEt.text.toString())
                intent.putExtra("pwd", binding.signUpPasswordEt.text.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
```

> 2-2 성장과제: ScrollView

- 자기소개가 길어지면 화면에 보이지 않는 뷰도 생기게 됨, 스크롤을 가능하게 하기(Hint: ScrollView)

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.core.widget.NestedScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".HomeActivity">

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        
        <TextView
            android:id="@+id/home_introduce_tv"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginHorizontal="20dp"
            android:layout_marginTop="20dp"
            android:text="@string/introduce"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@id/home_mbti_tv" />
        
    </androidx.constraintlayout.widget.ConstraintLayout>

</androidx.core.widget.NestedScrollView>

```

- 사진의 비율을 1:1로 만들기 (Hint: constraintDimensionRatio)

```kotlin
<ImageView
            android:id="@+id/home_profile_iv"
            android:layout_width="0dp"
            android:layout_height="100dp"
            android:layout_marginTop="50dp"
            android:scaleType="fitXY"
            android:src="@drawable/profile"
            app:layout_constraintDimensionRatio="1:1"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />
```

### 03 도전 과제

> 3-1 도전과제: ViewBinding에서 DataBinding으로

- ViewBinding에서 DataBinding으로 바꾸기

- build.gradle (모듈)
```kotlin
plugins {
    ...
    id 'kotlin-kapt'
}

android {
    ...
    dataBinding {
          enabled true
}
```

xml파일들을 <layout> ... <data> ... </data> ... </layout>으로 감싸주었다

- HomeActivity
```kotlin
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
    }
}
```

- ViewBinding과 DataBinding의 개념

View Binding과 Data Binding은 호환이 되기 때문에 같은 모듈에서 동시에 사용가능하다

ViewBinding: 뷰 결합 기능으로 뷰와 상호작용하는 코드를 쉽게 작성하게 도와주는 라이브러리
1. Null안전
2. 유형안전
3. 빠른 컴파일 속도

DataBinding: UI요소와 데이터를 프로그램적으로 연결하지 않고, 선언적 형식으로 결합할 수 있게 도와주는 라이브러리
1. Null안전
2. 메모리 누수 방지
3. UI 새로고침에 대해 걱정할 필요가 없다

차이점
1. 뷰바인딩의 속도가 더 빠르다
2. 데이터바인딩은 <layout> 태그를 사용하여 만든 레이아웃을 처리한다
3. 데이터바인딩은 양방향 바인딩을 지원한다
            
> 3-2 도전과제: MVVM으로 과제 구현
            
---
            
## __참고자료__

https://philosopher-chan.tistory.com/1307  
https://velog.io/@yxnsx/Android-DataBinding
https://salix97.tistory.com/243
            
            
            
            
            
