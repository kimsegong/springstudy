package com.gdu.staff.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StaffDto {
 private String sno;
 private String name;
 private String dept;
 private int salary;
}
