## WEEK 1 ANDROID SEMINAR 1차 과제

### 01 필수 과제

> 1-1 필수과제: 로그인 페이지 만들기(SignInActivity)

- 아이디, 비밀번호 모두 입력이 되어있을 떄만 로그인 버튼을 눌렀을떄 HomeActivity로 이동("로그인 성공" 이라는 토스트 메시지 출력), 아이디, 비밀번호 둘중 하나라도 비어있다면 "아이디/비밀번호를 확인해주세요" 라는 토스트 메시지 출력)

```kotlin
binding.mainLoginBt.setOnClickListener {
            if (binding.mainIdEt.text.isNullOrBlank() || binding.mainPasswordEt.text.isNullOrBlank()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, EmptyActivity::class.java)
                startActivity(intent)
            }
        }
```

- 비밀번호 EditTextView 입력 내용 가리기(InputType 속성), 모든 EditTextView는 미리보기 글씨가 있어야 함(hint 속성)

```kotlin
<EditText
        android:id="@+id/main_password_et"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginHorizontal="20dp"
        android:layout_marginTop="10dp"
        android:hint="비밀번호를 입력해주세요."
        android:inputType="textPassword"
        app:layout_constraintTop_toBottomOf="@id/main_password_tv" />
```

- 회원가입 버튼을 클릭시 SignUpActivity로 이동

```kotlin
binding.mainJoinBt.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
```

> 1-2 필수과제: 회원가입 페이지 만들기(SignUpActivity)

- 이름, 아이디, 비밀번호 모두 입력이 되어있을 때만 회원가입 버튼을 눌렀을때 다시 SignInActivity로 이동(이때는 intent가 아닌 finish 활용)
- 이름, 아이디, 비밀번호 중 하나라도 비어있다면 "입력되지 않은 정보가 있습니다" 라는 토스트 메시지 출력
- 비밀번호 EditTextView 입력 내용 가리기(InputType 속성)
- 모든 EditTextView는 미리보기 글씨가 있어야 함(hint 속성)

> 1-3 필수과제: 자기소개 페이지 만들기(HomeActivity)

- ImageView, TextView 활용
- 이름, 나이, MBTI 등 자기소개 작성

### 02 성장 과제

> 2-1 성장과제: 화면이동 + @

- 회원가입:SignUpActivity)이 성공한다면 이전 로그인 화면으로 돌아온다
- 회원가입 화면에서 로그인화면으로 돌아갈떄 회원가입에서 입력했던 아이디와 비밀번호가 입력되어 있어야 함(Hint : registerForActivityResult, putExtra)

> 2-2 성장과제: ScrollView

- 자기소개가 길어지면 화면에 보이지 않는 뷰도 생기게 됨, 스크롤을 가능하게 하기(Hint: ScrollView)
- 사진의 비율을 1:1로 만들기 (Hint: constraintDimensionRatio)

### 03 도전 과제

> 3-1 도전과제: ViewBinding에서 DataBinding으로

- ViewBinding에서 DataBinding으로 바꾸기
- ViewBinding과 DataBinding의 개념

> 3-2 도전과제: MVVM으로 과제 구현
