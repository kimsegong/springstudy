package com.gdu.app.service;

import java.util.List;

import com.gdu.app.dto.NoticeDto;

public interface NoticeService {
  int modifyNotice(NoticeDto noticeDto);
  NoticeDto getNotice(int noticeNo);
  List<NoticeDto> getNoticeList();
  int addNotice(NoticeDto noticeDto);
}
