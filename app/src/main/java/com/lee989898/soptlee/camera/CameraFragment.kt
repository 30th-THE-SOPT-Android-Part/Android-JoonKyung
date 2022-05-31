package com.lee989898.soptlee.camera

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import com.bumptech.glide.Glide
import com.lee989898.soptlee.R
import com.lee989898.soptlee.databinding.FragmentCameraBinding
import com.lee989898.soptlee.util.binding.BindingFragment
import java.lang.Exception

class CameraFragment : BindingFragment<FragmentCameraBinding>(R.layout.fragment_camera) {

    private val requestCode = 10

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cameraFragment = this
    }

    fun gallerySelect() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = MediaStore.Images.Media.CONTENT_TYPE

        startActivityForResult(intent, requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == requestCode) {
            if (resultCode == Activity.RESULT_OK) {
                try {
                    val uri = data?.data
                    Glide.with(this)
                        .load(uri)
                        .circleCrop()
                        .into(binding.cameraImgIv)
                } catch (e: Exception) {

                }
            } else if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }
}