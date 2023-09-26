package com.gdu.app02.anno01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
  private String name;
  private double height; // cm
  private double weight; // kg
  private double bmi;    // weight / (height * height)
  private String status; // <20: 저체중, < 25 : 정상, < 30 : 과체중, 비만
  private Calculator calculator;
  
  
}
