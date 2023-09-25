package com.gdu.app02.xml01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
  private String name;
  private Contact contact;
  private Address address;
}
