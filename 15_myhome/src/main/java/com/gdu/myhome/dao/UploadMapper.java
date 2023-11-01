package com.gdu.myhome.dao;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.myhome.dto.AttachDto;
import com.gdu.myhome.dto.UploadDto;

@Mapper
public interface UploadMapper {
  public int insertUpload(UploadDto upload);
  public int insertAttach(AttachDto attach);
}
