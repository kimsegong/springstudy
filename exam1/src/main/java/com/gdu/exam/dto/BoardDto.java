package com.gdu.exam.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDto {
  private int boardNo;
  private String author;
  private String title;
  private String content;
  private int hit;
  private String ip;
  private Date postDate;
}
