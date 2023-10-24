package com.gdu.app08.service;

import java.util.Map;

public interface MemberService {
  public Map<String, Object> getBmiInfo(int memberNo);
  public byte[] getProfileImage(int memberNo);
}
