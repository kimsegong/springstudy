package com.gdu.app11.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactDto {
  private int contactNo;
  private String name;
  private String tel;
  private String email;
  private String address;
  private String createdAt;
}