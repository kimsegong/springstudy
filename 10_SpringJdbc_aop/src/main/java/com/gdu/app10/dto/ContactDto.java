package com.gdu.app10.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactDto {

  private int contact_no;
  private String name;
  private String tel;
  private String email;
  private String address;
  private String created_at;
  
}
