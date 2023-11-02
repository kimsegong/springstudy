package com.gdu.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class MovieDto {
  private int no;
  private String title;
  private String genre;
  private String description;
  private double star;
}
