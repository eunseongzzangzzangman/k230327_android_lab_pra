package com.example.firebasetest20.util

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.text.SimpleDateFormat
import java.util.Date

//해당 코틀린 파일인데, 함수를 리팩토링, 파일로 따로 분리해서,
//자주 사용하는 기능을 분리
//매개변수에 타입이 액티비티로 사용이 되는 부분 확인
fun myCheckPermission(activity: AppCompatActivity) {

    //인텐트, 후처리하는 함수
    //권한 여부를 확인 하는 후처리 기능 -> ActivityResultContracts.RequestPermission()
    val requestPermissionLauncher = activity.registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        if (it) { //앱이 시작할 때, 미디어 이미지 장소에 접근이 가능하면, 시작 시 토스트 메시지 확인 가능함
            Toast.makeText(activity, "권한 승인", Toast.LENGTH_SHORT).show()
        } else {
            // 33버전 이후는 세분화된 미디어 권한 확인 해야 함
            Toast.makeText(activity, "권한 거부", Toast.LENGTH_SHORT).show()
        }
    }

    if (ContextCompat.checkSelfPermission(
            activity,
            Manifest.permission.READ_MEDIA_IMAGES
        ) !== PackageManager.PERMISSION_GRANTED
    ) {
        requestPermissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES)
    }
}

//지정한 날짜 형식의 문자열을 -> 데이트 타입으로 변환 하는 함수
fun dateToString(date: Date): String {
    val format = SimpleDateFormat("yyyy-MM-dd")
    return format.format(date)
}

//이미지를 압축하는 기능이 없음
//이미지 압축 하는 함수를 가져 와서, 여기에 선언 하여, 해당 액티비티에서 사용함