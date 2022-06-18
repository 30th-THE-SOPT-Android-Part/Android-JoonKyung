package com.lee989898.soptlee.ui.camera

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.lee989898.soptlee.R
import com.lee989898.soptlee.databinding.FragmentCameraBinding
import com.lee989898.soptlee.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CameraFragment : BindingFragment<FragmentCameraBinding>(R.layout.fragment_camera) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cameraFragment = this
        onActivityResult()
    }

    private fun onActivityResult() {
        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val uri = result.data?.data
                    Glide.with(this)
                        .load(uri)
                        .circleCrop()
                        .into(binding.cameraImgIv)
                }
            }

        binding.cameraInsertBt.setOnClickListener {
            val cameraIntent = Intent(Intent.ACTION_PICK)
            cameraIntent.type = MediaStore.Images.Media.CONTENT_TYPE
            resultLauncher.launch(cameraIntent)
        }
    }
}