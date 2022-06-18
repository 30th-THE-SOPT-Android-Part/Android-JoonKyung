package com.lee989898.soptlee.ui.setting

import android.os.Bundle
import com.lee989898.soptlee.R
import com.lee989898.soptlee.databinding.ActivitySettingBinding
import com.lee989898.soptlee.util.SharedPreferences
import com.lee989898.soptlee.util.binding.BindingActivity
import com.lee989898.soptlee.util.showToast

class SettingActivity : BindingActivity<ActivitySettingBinding>(R.layout.activity_setting) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.settingActivity = this
    }

    fun autoLoginClear(){
        showToast("자동로그인이 해제되었습니다.")
        SharedPreferences.setLogout(this)
    }

}