package com.gdu.app01.anno01;


public class Calculator {
  
  // no field
  
  // default constructor : new Calculator()
  
  // method
  public void add(int a, int b) {
    System.out.println(a + "+" + b + "=" + (a + b));
  }
  public void sub(int a, int b) {
    System.out.println(a + "-" + b + "=" + (a - b));
  }
  public void mul(int a, int b) {
    System.out.println(a + "X" + b + "=" + (a * b));
  }
  public void div(int a, int b) {
    System.out.println(a + "/" + b + "=" + (a / b));
  }
  

}
