package com.gdu.app09.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdu.app09.dao.ContactDao;
import com.gdu.app09.dto.ContactDto;

import lombok.RequiredArgsConstructor;

@Service  // ContactService 타입의 객체(Bean)을 Spring Container에 저장한다.
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

  
  private final ContactDao contactDao;
  
  @Override
  public int addContact(ContactDto contactDto) {
    int addResult = contactDao.insert(contactDto);
    return addResult;
  }
  @Override
  public int modifyContact(ContactDto contactDto) {
    int modifyResult = contactDao.update(contactDto);
    return modifyResult;
  }
  @Override
  public int deleteContact(int contact_no) {
    int deleteResult = contactDao.delete(contact_no);
    return deleteResult;
  }
  @Override
  public List<ContactDto> getContactList() {
    return contactDao.selectList();
  }
  @Override
  public ContactDto getContactByNo(int contact_no) {  
    return contactDao.selectContactByNo(contact_no);
  }
}
