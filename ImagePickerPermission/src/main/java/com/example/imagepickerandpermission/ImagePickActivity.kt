package com.example.imagepickerandpermission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.imagepickerandpermission.databinding.ActivityImagePickBinding

class ImagePickActivity : AppCompatActivity() {
    lateinit var binding: ActivityImagePickBinding
    private val REQ_GALLERY = 100
    private val REQ_CAMERA = 200
    lateinit var binding: ActivityImagePickBinding

    private val galleryResult = registerForActivityResult(ActivityResultContracts.GetContent()){
        if(it!=null){
            binding.imageView.setImageURI(it)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImagePickBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}