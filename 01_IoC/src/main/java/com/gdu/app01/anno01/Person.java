package com.gdu.app01.anno01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
  private String name;
  private int age;
  private Calculator calculator;
  
}
