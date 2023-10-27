package com.gdu.myhome.service;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.myhome.dao.BlogMapper;
import com.gdu.myhome.dto.BlogDto;
import com.gdu.myhome.dto.BlogImageDto;
import com.gdu.myhome.util.MyFileUtils;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BlogServiceImpl implements BlogService {

  private final BlogMapper blogMapper;
  private final MyFileUtils myFileUtils;
  
  @Override
  public Map<String, Object> imageUpload(MultipartHttpServletRequest multipartRequest) {
    
    // 이미지가 저장될 경로
    String imagePath = myFileUtils.getBlogImagePath();
    File dir = new File(imagePath);
    if(!dir.exists()) {
      dir.mkdirs();
    }
    // 이미지 파일 (CKEditor는 이미지를 upload라는 이름으로 보냄)
    MultipartFile upload = multipartRequest.getFile("upload");
    
    // 이미지가 저장될 이름
    String originalFilename = upload.getOriginalFilename();
    String filesystemName = myFileUtils.getFilesystemName(originalFilename);
    
    // 이미지 File 객체
    File file = new File(dir, filesystemName);
    
    // 저장
    try {
      upload.transferTo(file);
    }catch (Exception e) {
      e.printStackTrace();
    }
    
    // CKEditor로 저장된 이미지의 경로를 JSON 형식으로 반환해야 함   
    return Map.of("uploaded", true
                , "url", multipartRequest.getContextPath() + imagePath + "/" + filesystemName);
  }
  
  @Override
  public int addBlog(HttpServletRequest request) {
    
    // BLOG_T에 추가할 데이터
    String title = request.getParameter("title");
    String contents = request.getParameter("contents");
    int userNo = Integer.parseInt(request.getParameter("userNo"));
    String ip = request.getRemoteAddr();

    // BLOGDTO 생성
    BlogDto blog = BlogDto.builder()
                     .title(title)
                     .contents(contents)
                     .userNo(userNo)
                     .ip(ip)
                     .build();
    // BLOG_T에 추가
    // BlogMapper의 insertBlog() 메서드를 실행하면
    // 메서드로 전달환 blog 객체에 blogNo값이 저장된다.
    int addResult = blogMapper.insertBlog(blog);
    
    // BLOG 작성시 사용한 이미지 목록 (Jsoup 라이브러리 사용)
    Document document = Jsoup.parse(contents);
    Elements elements = document.getElementsByTag("img");
    
    if(elements != null) {
      for(Element element : elements) {
        String src = element.attr("src");
        String filesystemName = src.substring(src.lastIndexOf("/") + 1);
        BlogImageDto blogImage = BlogImageDto.builder()
                                    .blogNo(blog.getBlogNo())
                                    .imagePath(myFileUtils.getBlogImagePath())
                                    .filesystemName(filesystemName)
                                    .build();
        blogMapper.insertBlogImage(blogImage);
      }
    }
    
    return addResult;
  }
}
