package com.gdu.app12.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.app12.dao.ContactMapper;
import com.gdu.app12.dto.ContactDto;

import lombok.RequiredArgsConstructor;
@Transactional
@RequiredArgsConstructor  // private final ContactDao contactDao;에 @Autowired를 하기 위한 코드이다.
@Service  // ContactService 타입의 객체(Bean)을 Spring Container에 저장한다.
public class ContactServiceImpl implements ContactService {

  private final ContactMapper contactDao;
  
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
  public int deleteContact(int contactNo) {
    int deleteResult = contactDao.delete(contactNo);
    return deleteResult;
  }
  @Transactional(readOnly=true)  // 조회용 (성능 이점)
  @Override
  public List<ContactDto> getContactList() {
    return contactDao.selectList();
  }
  @Transactional(readOnly=true) // 조회용 (성능 이점)
  @Override
  public ContactDto getContactByNo(int contactNo) {
    return contactDao.selectContactByNo(contactNo);
  }
  
  @Override
  public void txTest() {
    
    // @Transactional 활용한 트랜잭션 처리 테스트 메서드
    
    // "성공1개+실패1개" DB처리를 동시에 수행했을 때 모두 실패로 되는지 확인하기
    
    // 성공
    contactDao.insert(new ContactDto(0, "이름", "전화번호", "이메일", "주소", null));
    
    // 실패
    contactDao.insert(new ContactDto());  // NAME 칼럼은 NOT NULL이므로 전달된 이름이 없으면 Exception이 발생한다.
    
  }
  @Override
  public void deleteOldestContact() {
   contactDao.deleteOldestContact();
    
  }

}