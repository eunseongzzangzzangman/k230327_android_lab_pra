package com.example.firebasetest20.util

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.firebase.ui.storage.images.FirebaseImageLoader
import com.google.firebase.storage.StorageReference
import java.io.InputStream

@GlideModule
//@GlideModule => 모든 클래스에서
// Glide와 Firebase 다운로드 후, 이미지 처리 하는 부분을 편하게 사용 하기 위해
// 원래 비트맵 타입으로 변환 해서, 등록 후 사용 하는 부분 자동화했음
class MyAppGlideModule : AppGlideModule() {
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        // Register FirebaseImageLoader to handle StorageReference
        registry.append(
            StorageReference::class.java, InputStream::class.java,
            FirebaseImageLoader.Factory()
        )
    }
}