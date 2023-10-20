package com.gdu.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDto {
  private int no;
  private String author;
  private String title;
  private String content;
  private int hit;
  private String ip;
  private Data postDate;
}
