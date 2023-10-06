package com.gdu.app08.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {
  private int memberNo;
  private String name;
  private double height;
  private double weight;
}
