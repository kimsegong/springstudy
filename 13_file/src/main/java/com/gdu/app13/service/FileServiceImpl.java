package com.gdu.app13.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.app13.util.MyFIleUtil;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FileServiceImpl implements FileService {

  private final MyFIleUtil myFIleUtil;
  
  @Override
  public int upload(MultipartHttpServletRequest multipartRequest) {
    
    // 첨부된 파일들의 목록
    List<MultipartFile> files = multipartRequest.getFiles("files");
    
    // 순회
    for(MultipartFile multipartFile : files) {
     
      // 첨부 여부 확인
      if(multipartFile != null && !multipartFile.isEmpty()) {
        
         try {
           
           // 첨부 파일이 저장될 경로 가져오기
           String path = myFIleUtil.getPath();
           
           // 저장될 경로의 디렉토리 만들기
           File dir = new File(path);
           if(!dir.exists()) {
             dir.mkdirs();
           }    
           // 첨부 파일의 원래 이름 알아내기
           String originalName = multipartFile.getOriginalFilename();
           
           // 첨부 파일이 저장될 이름 가져오기
           String filesystemName = myFIleUtil.getFilesystemName(originalName);
           
           // 첨부 파일의 File 객체
           File file = new File(dir, filesystemName);
           
           // 첨부 파일 저장하기
           multipartFile.transferTo(file);
           
         } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return 0;
  }
   @Override
  public Map<String, Object> ajaxUpload(MultipartHttpServletRequest multipartRequest) {
     // 첨부된 파일들의 목록
     List<MultipartFile> files = multipartRequest.getFiles("files");
     
     // 순회
     for(MultipartFile multipartFile : files) {
      
       // 첨부 여부 확인
       if(multipartFile != null && !multipartFile.isEmpty()) {
         
          try {
            
            // 첨부 파일이 저장될 경로 가져오기
            String path = myFIleUtil.getPath();
            
            // 저장될 경로의 디렉토리 만들기
            File dir = new File(path);
            if(!dir.exists()) {
              dir.mkdirs();
            }    
            // 첨부 파일의 원래 이름 알아내기
            String originalName = multipartFile.getOriginalFilename();
            
            // 첨부 파일이 저장될 이름 가져오기
            String filesystemName = myFIleUtil.getFilesystemName(originalName);
            
            // 첨부 파일의 File 객체
            File file = new File(dir, filesystemName);
            
            // 첨부 파일 저장하기
            multipartFile.transferTo(file);
            
          } catch (Exception e) {
           e.printStackTrace();
         }
       }
     }
    return Map.of("success", true);
  }
}
