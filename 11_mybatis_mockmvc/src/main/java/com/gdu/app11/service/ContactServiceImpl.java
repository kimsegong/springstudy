package com.gdu.app11.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdu.app11.dao.ContactDao;
import com.gdu.app11.dto.ContactDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor  // private final ContactDao contactDao;에 @Autowired를 하기 위한 코드이다.
@Service  // ContactService 타입의 객체(Bean)을 Spring Container에 저장한다.
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
  
  @Override
  public void txTest() {
    
    // AOP를 활용한 트랜잭션 처리 테스트 메소드
    
    // "성공1개+실패1개" DB처리를 동시에 수행했을 때 모두 실패로 되는지 확인하기
    
    // 성공
    contactDao.insert(new ContactDto(0, "이름", "전화번호", "이메일", "주소", null));
    
    // 실패
    contactDao.insert(new ContactDto());  // NAME 칼럼은 NOT NULL이므로 전달된 이름이 없으면 Exception이 발생한다.
    
  }

}