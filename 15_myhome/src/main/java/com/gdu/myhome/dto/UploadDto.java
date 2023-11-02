package com.gdu.myhome.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadDto {

  private int uploadNo;
  private String title;
  private String contents;
  private String createdAt;
  private String modifiedAt;
  private int attachCount;  // UPLOAD_T에는 없는 칼럼이지만 목록 보기에서 첨부파일개스를 반환하므로 그 결과를 저장하기 위해서 추가함
  private UserDto userDto;  // private int userNo;
}
