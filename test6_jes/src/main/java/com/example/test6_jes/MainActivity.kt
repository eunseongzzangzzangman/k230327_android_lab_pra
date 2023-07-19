package com.example.test6_jes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.test6_jes.R

//액티비티 : 화면을 그려주는 역할
class MainActivity : AppCompatActivity() {
    //최초 한번 화면에 출력을 하는 역할
    override fun onCreate(savedInstanceState: Bundle?) {
        // savedInstanceState: Bundle? -> 임시 데이터 저장 객체
        super.onCreate(savedInstanceState)
        // 해당 레이아웃이 샘플로 리니어 사용하는 중
        // 이유? 제약 조건 설정이 간단해서
        // 뷰만 선택해서 배치만 하면 기본 세로, 가로방향으로 배치가 간단함
        setContentView(R.layout.activity_main)
    }
}