package com.gdu.app02.xml01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
  private String postcode;
  private String jibun;
  private String road;
}
