package com.gdu.myhome.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FreeDto {
  private int freeNo;
  private String email;
  private String contents;
  private Timestamp createdAt;
  private int status;
  private int depth;
  private int groupNo;
  private int groupOrder;

}
