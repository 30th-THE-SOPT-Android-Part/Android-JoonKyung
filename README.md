## WEEK 3 ANDROID SEMINAR 3차 과제

### 01 필수 과제

> 1-1 필수과제: 과제에 폰트 적용하기

```kotlin
// noto_sans_kr.xml
<?xml version="1.0" encoding="utf-8"?>
<font-family xmlns:android="http://schemas.android.com/apk/res/android">
    <font
        android:font="@font/noto_sans_kr_regular"
        android:fontWeight="400" />
    <font
        android:font="@font/noto_sans_kr_bold"
        android:fontWeight="700" />
</font-family>
```

전체적용 하면 편할꺼 같아서 themes.xml에서 전체적용 할라 했는데 다 달라서 포기했다

```kotlin
// themes.xml
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Theme.SOPTLEE" parent="Theme.AppCompat.Light">
        
        ...

        <item name="android:textViewStyle">@style/noto_bold_TextView</item>
        <item name="android:buttonStyle">@style/noto_bold_Button</item>

    </style>

    <style name="noto_bold_TextView" parent="android:Widget.TextView">
        <item name="android:fontFamily">@font/noto_sans_kr_bold</item>
    </style>

    <style name="noto_bold_Button" parent="android:Widget.Button">
        <item name="android:fontFamily">@font/noto_sans_kr_bold</item>
    </style>

</resources>
```

> 1-2 필수과제: 기존 HomeActivity에서 만들었던 내용들을 ProfileFragment로 만들어 주기

1-2-1: Button에 Selector 활용하기(선택되었을 떄, 선택되지 않았을 떄)

```kotlin
// fragment_profile.xml
<Button
  android:id="@+id/profile_follower_list_bt"
  android:layout_width="match_parent"
  android:layout_height="46dp"
  android:layout_marginStart="11dp"
  android:layout_marginTop="13dp"
  android:layout_marginEnd="8dp"
  android:layout_marginBottom="13dp"
  android:layout_weight="1"
  android:background="@drawable/selector_pressed_stroke"
  android:fontFamily="@font/noto_sans_kr_medium"
  android:text="팔로워 목록"
  android:textColor="@drawable/selector_pressed_text"
  android:textSize="14sp" />
```

background에 selector로 만든 xml을 넣어줬다

```kotlin
// selector_pressed_stroke.xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@drawable/button_click" android:state_selected="true" />
    <item android:drawable="@drawable/button_unclick" android:state_selected="false" />
</selector>
```

1-2-2: 이미지의 경우 원형으로 표시되게 만들기

둥근 이미지뷰를 만들기 위해 CircleImageView 라이브러리를 사용했다

```kotlin
// build.gradle
implementation 'de.hdodenhof:circleimageview:3.1.0'
```

```kotlin
// fragment_home.xml
<de.hdodenhof.circleimageview.CircleImageView
    android:id="@+id/profile_image_iv"
    android:layout_width="80dp"
    android:layout_height="80dp"
    android:layout_marginTop="20dp"
    android:src="@drawable/profile"
    app:civ_border_color="@color/thesopt_purple"
    app:civ_border_width="2dp"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```

1-2-3: 아이콘은 svg 혹은 이미지(png, jpg)등으로 export해서 사용

피그마에서 PNG로 다운받아 drawable에 넣어서 사용했습니다

1-2-4: Activity 하단에 BottomNaviagation 넣어주기

```
// activity_home.xml
<com.google.android.material.bottomnavigation.BottomNavigationView
            android:id="@+id/home_bnv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@color/white"
            app:itemIconTint="@color/home_bottom_navi"
            app:itemRippleColor="#6424D5"
            app:itemTextColor="@color/home_bottom_navi"
            app:layout_constraintBottom_toBottomOf="parent"
            app:menu="@menu/home_menu" />
```

내비게이션 바에서 보여줄 3개의 프래그먼트를 만들고 HomeActivity에서 연결해주었다

```
// HomeActivity.kt
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeViewPagerAdapter: HomeViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
        initBottomNavi()
    }

    private fun initAdapter(){
        val fragmentList = listOf(ProfileFragment(), HomeFragment() , CameraFragment())
        homeViewPagerAdapter = HomeViewPagerAdapter(this)
        homeViewPagerAdapter.fragments.addAll(fragmentList)

        binding.homeVp.adapter = homeViewPagerAdapter

    }

    private fun initBottomNavi(){

        binding.homeVp.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.homeBnv.menu.getItem(position).isChecked = true
            }
        })

        binding.homeBnv.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_profile -> {
                    binding.homeVp.currentItem = FIRST_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                R.id.home_home -> {
                    binding.homeVp.currentItem = SECOND_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                else -> {
                    binding.homeVp.currentItem = THIRD_FRAGMENT
                    return@setOnItemSelectedListener true
                }
            }
        }



    }

    companion object {
        const val FIRST_FRAGMENT = 0
        const val SECOND_FRAGMENT = 1
        const val THIRD_FRAGMENT = 2
    }


}
```

> 1-3 필수과제: TabLayout + ViewPager2를 HomeFragment 안에 넣어주기, TabLayout에 텍스트, 인디케이터 색상 설정하기

```kotlin
// fragment_home.xml
<com.google.android.material.tabs.TabLayout
            android:id="@+id/home_tab_tl"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:textSize="16sp"
            app:layout_constraintTop_toBottomOf="@id/home_logo_name_tv"
            app:tabIndicator="@font/noto_sans_kr_medium"
            app:tabIndicatorColor="@color/sopt_main_purple"
            app:tabIndicatorHeight="3dp"
            app:tabSelectedTextColor="@color/sopt_main_purple" />

        <androidx.viewpager2.widget.ViewPager2
            android:id="@+id/home_viewPager_vp"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintTop_toBottomOf="@id/home_tab_tl" />
```

텍스트, 인디게이터 색상은 TabLayout 속성을 활용하여 해주었다

```kotlin
// HomeFragment.kt
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeTabViewPagerAdapter: HomeTabViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        initAdapter()
        initTabLayout()

        return binding.root
    }

    private fun initAdapter(){
        val fragmentList = listOf(HomeFollowerFragment(), HomeFollowingFragment())

        homeTabViewPagerAdapter = HomeTabViewPagerAdapter(this)
        homeTabViewPagerAdapter.fragments.addAll(fragmentList)

        binding.homeViewPagerVp.adapter = homeTabViewPagerAdapter
    }

    private fun initTabLayout(){
        val tabLabel = listOf("팔로잉", "팔로워")

        TabLayoutMediator(binding.homeTabTl, binding.homeViewPagerVp){tab, position ->
            tab.text = tabLabel[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
```

### 02 성장 과제

> 2-1 성장과제: ViewPager2 중첩 스크롤 문제 해결하기

### 03 도전 과제

> 3-1 도전과제: 갤러리에서 받아온 이미지(Uri)를 Glide를 사용해서 화면에 띄워보기

### 이번 과제를 통해 배운 내용

리사이클러뷰 삭제와 이동하는법을 배워서 유용하게 쓸 수 있겠다.  
ItemDecoration을 활용해서 다양하게 디자인 해봐야 겠다.  
도전 과제는 나중에 적용해봐야겠다

## __참고자료__

https://philosopher-chan.tistory.com/1307
https://velog.io/@yxnsx/Android-DataBinding
https://salix97.tistory.com/243
https://developer.android.com/topic/performance/vitals/render?hl=ko
https://charlezz.medium.com/%EB%B3%B4%EC%9D%BC%EB%9F%AC%ED%94%8C%EB%A0%88%EC%9D%B4%ED%8A%B8-%EC%BD%94%EB%93%9C%EB%9E%80-boilerplate-code-83009a8d3297
            
            
        
            
            
