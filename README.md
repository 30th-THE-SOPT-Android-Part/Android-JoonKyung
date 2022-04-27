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
1-2-2: 이미지의 경우 원형으로 표시되게 만들기
1-2-3: 아이콘은 svg 혹은 이미지(png, jpg)등으로 export해서 사용
1-2-4: Activity 하단에 BottomNaviagation 넣어주기

> 1-3 필수과제: TabLayout + ViewPager2를 HomeFragment 안에 넣어주기, TabLayout에 텍스트, 인디케이터 색상 설정하기

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
            
            
        
            
            
