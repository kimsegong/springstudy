package com.gdu.app11.service;

import java.util.List;

import com.gdu.app11.dto.ContactDto;

public interface ContactService {
  public int addContact(ContactDto contactDto);
  public int modifyContact(ContactDto contactDto);
  public int deleteContact(int contact_no);
  public List<ContactDto> getContactList();
  public ContactDto getContactByNo(int contact_no);
  public void txTest();
}