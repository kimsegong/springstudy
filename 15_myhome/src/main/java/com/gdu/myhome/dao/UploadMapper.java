package com.gdu.myhome.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.myhome.dto.AttachDto;
import com.gdu.myhome.dto.UploadDto;

@Mapper
public interface UploadMapper {
  public int insertUpload(UploadDto upload);
  public int insertAttach(AttachDto attach);
  public int getUploadCount();
  public List<UploadDto> getUploadList(Map<String, Object> map);
  public UploadDto getUpload(int uploadNo);
  public List<AttachDto> getAttachList(int uploadNo);
  public AttachDto getAttach(int attachNo);
  public int updateDownloadCount(int attachNo);
}