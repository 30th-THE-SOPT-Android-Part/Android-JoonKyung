## WEEK 2 ANDROID SEMINAR 2차 과제

### 01 필수 과제

> 1-1 필수과제: 자기소개 페이지를 만든 HomeActivity 하단에 FollowerRecyclerView, RepositoryRecyclerView 만들기 (HomeActivity.kt)

1-1-1: Button, TextView 활용

- activity_home.xml
```kotlin
<LinearLayout
                android:id="@+id/home_button_ll"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginHorizontal="20dp"
                android:layout_marginTop="20dp"
                app:layout_constraintTop_toBottomOf="@id/home_mbti_tv">

                <Button
                    android:id="@+id/home_follower_list_bt"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginEnd="20dp"
                    android:layout_weight="1"
                    android:background="@drawable/follower_round_button"
                    android:text="팔로워\n 목록"
                    android:textSize="16sp"
                    android:textColor="@color/white"
                    android:textStyle="bold"
                    app:layout_constraintTop_toBottomOf="@id/home_mbti_tv" />

                <Button
                    android:id="@+id/home_repo_list_bt"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:textSize="16sp"
                    android:layout_marginStart="20dp"
                    android:layout_weight="1"
                    android:background="@drawable/repository_round_button"
                    android:text="레포지토리\n 목록"
                    android:textColor="@color/white"
                    android:textStyle="bold"
                    app:layout_constraintTop_toBottomOf="@id/home_mbti_tv" />

            </LinearLayout>
```

리니어 레이아웃에 넣고 layout_weight를 1을 주어 반반씩 차지하게 했다

- repository_round_button.xml
```kotlin
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">

    <item>

        <shape>

            <gradient android:angle="45"
                android:centerColor="#808080"
                android:endColor="#D3D3D3"
                android:startColor="@color/black"
                android:type="linear" />

            <stroke android:width="1dp" android:color="#ff888888">

            </stroke>

            <corners android:radius="10dp" />

        </shape>


    </item>

</selector>
```

버튼의 그라데이션 색상과 테두리 둥글게 하는 것을 drawable 폴더에 repository_round_button 과 follower_round_button xml파일을 만들어서 구현하였다

1-1-2: FollowerRecyclerView, RepositoryRecyclerView 만들기

- item_follower_list.xml
```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:background="@drawable/item_round"
    android:layout_height="wrap_content"
    android:layout_marginBottom="10dp"
    android:paddingVertical="10dp">

    <ImageView
        android:id="@+id/follower_profile_iv"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:src="@drawable/profile"
        android:padding="10dp"
        android:layout_marginStart="20dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintDimensionRatio="1:1"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintWidth_percent="0.25" />

    <TextView
        android:id="@+id/follower_name_tv"
        android:layout_width="wrap_content"
        android:layout_marginTop="10dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:textColor="@color/black"
        android:textSize="20sp"
        app:layout_constraintStart_toEndOf="@id/follower_profile_iv"
        app:layout_constraintTop_toTopOf="@id/follower_profile_iv"
        tools:text="이름" />

    <TextView
        android:id="@+id/follower_introduce_tv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textColor="@color/black"
        android:textSize="14sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="@id/follower_name_tv"
        app:layout_constraintTop_toBottomOf="@id/follower_name_tv"
        tools:text="자기 소개 텍스트 입니다" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

- item_repository_list.xml
```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginHorizontal="20dp"
    android:layout_marginBottom="10dp"
    android:background="@drawable/item_round"
    android:paddingVertical="10dp">

    <TextView
        android:id="@+id/repository_title_tv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginTop="5dp"
        android:textColor="@color/black"
        android:textSize="20sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_goneMarginStart="20dp"
        tools:text="안드로이드 과제 레포지토리" />

    <TextView
        android:id="@+id/repository_part_tv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginTop="10dp"
        android:layout_marginEnd="20dp"
        android:ellipsize="end"
        android:maxLines="2"
        android:textColor="@color/black"
        android:textSize="14sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/repository_title_tv"
        tools:text="안드로이드 파트 과제" />


</androidx.constraintlayout.widget.ConstraintLayout>
```

1-1-3: 각각의 RecyclerView 담고있는 Fragment 2개 만들기

- fragment_follower
```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_marginHorizontal="20dp"
    android:layout_height="match_parent"
    tools:context=".FollowerFragment">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/follower_list_rv"
        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
        tools:itemCount="4"
        tools:listitem="@layout/item_follower_list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

- fragment_repository
```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".RepositoryFragment">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/repository_list_rv"
        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
        tools:itemCount="4"
        tools:listitem="@layout/item_repository_list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

1-1-4: 각각의 버튼 눌렀을 떄 알맞은 Fragment로 전환되게 하기, defalut로 보이는 Fragment는 FollowerRecyclerView를 담은 Fragment로 하기

- HomeActivity.kt
```kotlin
package com.lee989898.soptlee.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lee989898.soptlee.*
import com.lee989898.soptlee.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initTransactionEvent()
    }

    private fun initTransactionEvent() {
        val followerFragment = FollowerFragment()
        val repositoryFragment = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.home_list_fcv, followerFragment).commit()

        binding.homeRepoListBt.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.home_list_fcv, repositoryFragment)
            transaction.commit()
        }

        binding.homeFollowerListBt.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.home_list_fcv, followerFragment)
            transaction.commit()
        }

    }
}
```

1-1-5: 설명이 너무 길어서 글씨가 길어지면 뒤에 ... 으로 표시되게 하기 (xml의 ellipsize 속성과, maxLine 속성 할용)

- item_repository_list.xml
```kotlin
<TextView
        android:id="@+id/repository_part_tv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginTop="10dp"
        android:layout_marginEnd="20dp"
        android:ellipsize="end"
        android:maxLines="2"
        android:textColor="@color/black"
        android:textSize="14sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/repository_title_tv"
        tools:text="안드로이드 파트 과제" />
```

android:ellipsize="end"로 줄 끝 부분에 ...이 나오게 했다  
android:maxLines="2"로 두줄을 넘어가면 나머지 부분은 나오지 않게 했다

> 1-2 필수과제:  둘 중 하나의 RecyclerView는 Gird Layout으로 만들기

- fragment_repository.xml
```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".RepositoryFragment">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/repository_list_rv"
        app:layoutManager="androidx.recyclerview.widget.GridLayoutManager"
        app:spanCount="2"
        tools:itemCount="4"
        tools:listitem="@layout/item_repository_list"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

app:layoutManager="androidx.recyclerview.widget.GridLayoutManager"로 그리드 레이아웃 매니저를 설정했다  
app:spanCount="2"로 행에서 몇개씩 보일건지 설정해주었다

### 02 성장 과제

> 2-1 성장과제: 아이템 클릭시 상세 설명을 보여주는 Activity로 이동하기 (DetailActivity.kt)

2-1-1: 아이템 클릭시 해당 아이템의 이름과 설명 값을 DetailActivity에서 보여주기

- FollowerAdapter

```kotlin
package com.lee989898.soptlee

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.lee989898.soptlee.databinding.ItemFollowerListBinding

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {

    val followerList = mutableListOf<FollowerData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding =
            ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(followerList[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView?.context, DetailActivity::class.java)
            intent.putExtra("name", followerList[position].name)
            intent.putExtra("introduction", followerList[position].introduction)
            ContextCompat.startActivity(holder.itemView.context, intent, null)
        }

    }

    override fun getItemCount(): Int = followerList.size


    class FollowerViewHolder(
        private val binding: ItemFollowerListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init{
            itemView.setOnClickListener {

            }
        }

        fun onBind(data: FollowerData) {
            binding.followerNameTv.text = data.name
            binding.followerIntroduceTv.text = data.introduction
        }
    }
}
```

- DetailActivity.kt

```kotlin
package com.lee989898.soptlee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lee989898.soptlee.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.detailNameTv.append(intent.getStringExtra("name"))
        binding.detailIntroductionTv.append(intent.getStringExtra("introduction"))
    }
}
```

> 2-2 성장과제: ItemDecoration 활요해서 리스트 간 간격 또는 구분선 주기

- 구분선
```kotlin
val dividerItemDecoration =
            DividerItemDecoration(binding.followerListRv.context, LinearLayoutManager(requireContext()).orientation)

        binding.followerListRv.addItemDecoration(dividerItemDecoration)
```

- 아이템 간격
```kotlin
val layoutParams = holder.itemView.layoutParams
        layoutParams.height = 500
        holder.itemView.requestLayout()
```

- 아이템들을 유연하게 꾸미기, ItemDecoration을 활용해서 구분선 or 아이템 간 간격(margin) 주기

> 2-3 성장과제: RecyclerView Item 이동 삭제 구현

- RecyclerView Item 기능 구현하기
  - item 길게 눌러 위치 변경하기
  - item을 옆으로 슬라이드 하면 삭제하는 기능 넣기

### 03 도전 과제

> 3-1 도전과제:

## __참고자료__

https://philosopher-chan.tistory.com/1307
https://velog.io/@yxnsx/Android-DataBinding
            https://salix97.tistory.com/243
            
            
            
            
            
