package com.example.k230327_android_lab_pra

import android.util.Log
import java.util.Scanner

class Test2 {
}

class LoginTest {
    companion object {
        //클래스 함수와 같음 -> 클래스명. 함수 :
        fun login(user:User){
            if(user.id.equals("admin") && user.pw.equals("1234")) {
                println("로그인 성공")
            }
        }
    }
}

//data class 임시 DTO(=VO), 데이터 전달을 하기 위한 객체
//클래스에서 만들어서 사용할 때, 주 생성자를 이용하되, 매개변수 부분에 변수 앞에 val 라는 키워드를 사용해서,
//전역으로 사용
data class User(val id : String, val pw : String) {

}

// 코틀린 : 모든 타입 객체
// 변수 선언, var (val) 변수명 : 타입=해당값 할당 형식
// ide 1차 문법체크 참고
val sc : Scanner = Scanner(System.`in`)

fun main() {


    println("ID 입력하세요 :")
    val id = sc.nextLine()
//    println("입력된 ID 확인 : $id")

    println("PW 입력하세요 :")
    val pw = sc.nextLine()
//    println("입력된 PW 확인 : $pw")

    val user: User = User(id,pw)
    println("user 확인 : $user")

    LoginTest.login(user) //(클래스명.함수)
}