package com.gdu.myhome.schedule;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gdu.myhome.dao.BlogMapper;
import com.gdu.myhome.dto.BlogImageDto;
import com.gdu.myhome.util.MyFileUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class BlogImageBatch {

  private final BlogMapper blogMapper;
  private final MyFileUtils myFileUtils;
  
  @Scheduled(cron="0 0 1 1/1 * ?")
  public void execute() {
    
    // 1. 어제 작성된 블로그의 이미지 목록(DB)
    List<BlogImageDto> blogImageList = blogMapper.getBlogImageInYesterday();
    
    // 2. List<BlogImageDto> -> List<Path> (Path는 경로+파일명으로 구성)
    List<Path> blogImagePathList = blogImageList.stream()
                                                .map(blogImageDto -> new File(blogImageDto.getImagePath(), blogImageDto.getFilesystemName()).toPath())
                                                .collect(Collectors.toList());
    
    // 3. 어제 저장된 블로그 이미지 목록 (디렉토리)
    File dir = new File(myFileUtils.getBlogImagePathInYesterday());
    
    // 4. 삭제할 File 객체들
    File[] targets =  dir.listFiles(file -> !blogImagePathList.contains(file.toPath()));
    
    // 5. 삭제
    if(targets != null && targets.length != 0) {
      for(File target : targets) {
        target.delete();
      }
    }
  }
  
}
