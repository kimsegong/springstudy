package com.gdu.myhome.service;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.myhome.dao.UploadMapper;
import com.gdu.myhome.dto.AttachDto;
import com.gdu.myhome.dto.UploadDto;
import com.gdu.myhome.dto.UserDto;
import com.gdu.myhome.util.MyFileUtils;
import com.gdu.myhome.util.MyPageUtils;

import lombok.RequiredArgsConstructor;
import net.coobird.thumbnailator.Thumbnails;

@Transactional
@RequiredArgsConstructor
@Service
public class UploadServiceImpl implements UploadService {

  private final UploadMapper uploadMapper;
  private final MyFileUtils myFileUtils;
  private final MyPageUtils myPageUtils;
  
  @Override
  public boolean addUpload(MultipartHttpServletRequest multipartRequest) throws Exception {
    
    String title = multipartRequest.getParameter("title");
    String contents = multipartRequest.getParameter("contents");
    int userNo = Integer.parseInt(multipartRequest.getParameter("userNo"));
    
    UploadDto upload = UploadDto.builder()
                        .title(title)
                        .contents(contents)
                        .userDto(UserDto.builder()
                                  .userNo(userNo)
                                  .build())
                        .build();
    
    int uploadCount = uploadMapper.insertUpload(upload);
    
    List<MultipartFile> files = multipartRequest.getFiles("files");
    
    int attachCount;
    if(files.get(0).getSize() == 0) {
      attachCount = 1;
    } else {
      attachCount = 0;
    }
    
    for(MultipartFile multipartFile : files) {
      
      if(multipartFile != null && !multipartFile.isEmpty()) {
        
        String path = myFileUtils.getUploadPath();
        File dir = new File(path);
        if(!dir.exists()) {
          dir.mkdirs();
        }
        
        String originalFilename = multipartFile.getOriginalFilename();
        String filesystemName = myFileUtils.getFilesystemName(originalFilename);
        File file = new File(dir, filesystemName);
        
        multipartFile.transferTo(file);
        
        String contentType = Files.probeContentType(file.toPath());  // 이미지의 Content-Type은 image/jpeg, image/png 등 image로 시작한다.
        int hasThumbnail = (contentType != null && contentType.startsWith("image")) ? 1 : 0;
        
        if(hasThumbnail == 1) {
          File thumbnail = new File(dir, "s_" + filesystemName);  // small 이미지를 의미하는 s_을 덧붙임
          Thumbnails.of(file)
                    .size(100, 100)      // 가로 100px, 세로 100px
                    .toFile(thumbnail);
        }
        
        AttachDto attach = AttachDto.builder()
                            .path(path)
                            .originalFilename(originalFilename)
                            .filesystemName(filesystemName)
                            .hasThumbnail(hasThumbnail)
                            .uploadNo(upload.getUploadNo())
                            .build();
        
        attachCount += uploadMapper.insertAttach(attach);
        
      }  // if
      
    }  // for
    
    return (uploadCount == 1) && (files.size() == attachCount);
    
  }
  
  @Override
  public Map<String, Object> getUploadList(HttpServletRequest request) {
  
    Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
    int page = Integer.parseInt(opt.orElse("1"));
    int total = uploadMapper.getUploadCount();
    int display = 9;
    
    myPageUtils.setPaging(page, total, display);
    
    Map<String, Object> map = Map.of("begin", myPageUtils.getBegin()
                                   , "end", myPageUtils.getEnd());
    
    List<UploadDto> uploadList = uploadMapper.getUploadList(map);
    
    return Map.of("uploadList", uploadList
                , "totalPage", myPageUtils.getTotalPage());
  }
  
}