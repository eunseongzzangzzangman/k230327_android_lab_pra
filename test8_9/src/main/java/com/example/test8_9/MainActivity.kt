package com.example.test8_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import com.example.test8_9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val TAG : String = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        //롱클릭 이벤트 리스너 확인
        //바인딩 작업 샘플 코드, 앞에 모듈에서 가져오기
        //버튼 하나를 가지고 확인
        binding.btn1?.setOnLongClickListener {
            Toast.makeText(this@MainActivity, "버튼 롱클릭 테스트", Toast.LENGTH_SHORT).show()
            true
        }
    }



    //이벤트 핸들러 처리 하는 방법 3가지. 그 중에서 SAM 기법, Single Abstrackt Method
    //추상 메서드가 하나인 인터페이스 -> 바로 람다식으로 사용 가능한 기법.
    //사전 작업이 필요.
    //새로 만든 모듈에는 빌드,그레들 파일에 뷰 바인딩 설정이 없음
    //참고, 앞 모듈에 설정코드, 복붙
    //체크박스 뷰, 버튼 뷰 설정
    //리스너 설정, 결과 확인
    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkbox_meat -> {
                    if (checked) {
                        Toast.makeText(this@MainActivity, "고기선택", Toast.LENGTH_SHORT).show()
                        // Put some meat on the sandwich
                    } else {
                        Toast.makeText(this@MainActivity, "고기선택해제", Toast.LENGTH_SHORT).show()
                        // Remove the meat
                    }
                }
                R.id.checkbox_cheese -> {
                    if (checked) {
                        Toast.makeText(this@MainActivity, "치즈선택", Toast.LENGTH_SHORT).show()
                        // Cheese me
                    } else {
                        Toast.makeText(this@MainActivity, "치즈선택해제", Toast.LENGTH_SHORT).show()
                        // I'm lactose intolerant
                    }
                }
                // TODO: Veggie sandwich
            }
        }
    }

    //벡 키 이벤트 따로 처리하는 함수
    override fun onBackPressed() {
        Log.d(TAG,"back 키 사용됨.")
    }

    //키 이벤트
//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        when (keyCode) {
//            KeyEvent.KEYCODE_BACK -> Log.d(TAG, "BACK Button을 눌렀네요")
//            KeyEvent.KEYCODE_VOLUME_UP -> Log.d(TAG, "Volume Up 키를 눌렀네요")
//            KeyEvent.KEYCODE_VOLUME_DOWN -> Log.d(TAG, "Volume Down 키를 눌렀네요")
//            KeyEvent.KEYCODE_0 -> Log.d(TAG, "0번 키를 눌렀네요")
//            KeyEvent.KEYCODE_ENTER -> Log.d(TAG, "enter 키를 눌렀네요")
//        }
//        return super.onKeyDown(keyCode, event)
//    }

    //터치 이벤트
//    override fun onTouchEvent(event: MotionEvent?): Boolean {
//        when(event?.action){
//            MotionEvent.ACTION_DOWN -> {
//                //로깅 관련된 프로그램. d:debug, e:error
//                Log.d(TAG,"Touch down event x : ${event.x} , rawX: ${event.rawX}, " +
//                        "y:${event.y} , rawY: ${event.y}")
//            }
//            MotionEvent.ACTION_UP -> {
//                Log.d(TAG,"Touch up event")
//            }
//
//            MotionEvent.ACTION_MOVE -> {
//                Log.d(TAG,"Touch Move event x : ${event.x} , rawX: ${event.rawX}, " +
//                        "y:${event.y} , rawY: ${event.y}")
//            }
//        }
//        return super.onTouchEvent(event)
//    }
}