package com.gdu.myhome.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class MyFileUtils {

  // 파일이 저장될 경로 반환하기
  public String getBlogImagePath() {
    /*    /storage/yyyy/MM/dd    */ 
    LocalDate today = LocalDate.now();
    return "/blog/" + DateTimeFormatter.ofPattern("yyyy/MM/dd").format(today);
 }
   // 파일이 저장될 이름 반환하기
   public String getFilesystemName(String originalFileName) {
    
    /* UUID.확장자 */
    
    String extName = null;
    if(originalFileName.endsWith("tar.gz")) {  // 확장자에 마침표가 포함되는 예외 경우를 처리한 
      extName = "tar.gz";
    } else {
      String[] arr = originalFileName.split("\\."); // [.] 또는 \\.
      extName = arr[arr.length - 1];
    }
    return UUID.randomUUID().toString().replace("-", "") + "." + extName;
  }
}
