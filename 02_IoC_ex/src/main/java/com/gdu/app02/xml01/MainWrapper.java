package com.gdu.app02.xml01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainWrapper {

  public static void main(String[] args) {
    
    AbstractApplicationContext ctx = new GenericXmlApplicationContext("xml01/appCtx.xml");
    
    Contact contact = ctx.getBean("contact", Contact.class);
    Person person = ctx.getBean("person", Person.class);
    Address address = ctx.getBean("address", Address.class);
    
    
    
    ctx.close();
  }
}
