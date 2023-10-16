package com.gdu.app14.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDto {
  private int memberNo;
  private String id;
  private String name;
  private String gender;
  private String address;
  
}
