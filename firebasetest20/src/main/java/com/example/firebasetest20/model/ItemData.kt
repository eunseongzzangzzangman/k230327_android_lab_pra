package com.example.firebasetest20.model

class ItemData {
    //docId : 파이어 스토어 = NoSQL, <->  ORDBMS(MySQL, Oracle 디비를 저장 하는 기능이 비슷 한거지, 이것의 종류는 다름)
    //컬렉션(마치 테이블처럼 사용), 문서(마치 행), docId(문서의 번호 -> 마치 PK)
    //문서번호, 자동으로 생성해서 사용중. 물론, 임의로 작성 가능(유니크 속성 주의해서 작성)
    var docId: String? = null
    //인증이 되면, 해당 이메일이 인증 객체에 등록이 됨
    var email: String? = null
    //메시지 -> 파이어 스토어에 저장 되는 문자열
    var content: String? = null
    //기본 날짜 -> simpleFormat 함수 이용 해서, 원하는 형식으로 날짜를 사용함
    var date: String? = null
}