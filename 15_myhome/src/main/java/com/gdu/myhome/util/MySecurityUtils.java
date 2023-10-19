package com.gdu.myhome.util;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

@Component
public class MySecurityUtils {

  /*
   * SHA256 암호화
   * 1. 입력값을 256비트(32바이트)로 암호화하는 해시 알고리즘이다.
   * 2. 원본을 암호화할 수 있으나, 암호화된 결과를 원본으로 되돌리는 복호화는 불가능하다.
   * 3. java.security 패키지를 활용해서 구하거나, 암호화 디펜던시(예시 commons-lang3)를 활용
   */
  public String getSHA256(String password) {
    StringBuilder sb = new StringBuilder();
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("SHA256");
      messageDigest.update(password.getBytes());
      byte[] b = messageDigest.digest(); // 암호화된 32비트 배열이 생성됨
      for(int i = 0; i < b.length; i++) {
        sb.append(String.format("%02X", b[i])); // 2자리 16진수 문자열로 변환하기
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return sb.toString();
  }
}
