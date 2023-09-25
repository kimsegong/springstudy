package com.gdu.app02.xml02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MyJdbcService {

  private MyJdbcDao myJdbcDao;
  
  public void add() {
    myJdbcDao.add();
  }
  public void remove() {
    myJdbcDao.remove();
  }
  public void modify() {
    myJdbcDao.modify();
  }
  public void select() {
    myJdbcDao.select();
  }
}
