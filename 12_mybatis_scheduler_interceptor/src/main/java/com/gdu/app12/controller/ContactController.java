package com.gdu.app12.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app12.dto.ContactDto;
import com.gdu.app12.service.ContactService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor  // private final ContactService contactService;에 @Autowired를 하기 위한 코드이다.
@Controller
public class ContactController {

  // ContactController를 실행할 때 org.slf4j.Logger가 동작한다.
  // private static final Logger log = LoggerFactory.getLogger(ContactController.class);
  
  private final ContactService contactService;
  
  @RequestMapping(value="/contact/list.do", method=RequestMethod.GET)
  public String list(Model model) {
    List<ContactDto> contactList = contactService.getContactList();
    model.addAttribute("contactList", contactList);
    return "contact/list";
  }
  
  @RequestMapping(value="/contact/write.do", method=RequestMethod.GET)
  public String write() {
    return "contact/write";
  }
  
  @RequestMapping(value="/contact/add.do", method=RequestMethod.POST)
  public String add(ContactDto contactDto, RedirectAttributes redirectAttributes) {
    int addResult = contactService.addContact(contactDto);
    redirectAttributes.addFlashAttribute("addResult", addResult);
    return "redirect:/contact/list.do";
  }
  
  @RequestMapping(value="/contact/detail.do", method=RequestMethod.GET)
  public String detail(@RequestParam(value="contactNo", required=false, defaultValue="0") int contactNo, Model model) {
    model.addAttribute("contact", contactService.getContactByNo(contactNo));
    return "contact/detail";
  }
  
  @RequestMapping(value="/contact/modify.do", method=RequestMethod.POST)
  public String modify(ContactDto contactDto, RedirectAttributes redirectAttributes) {
    int modifyResult = contactService.modifyContact(contactDto);
    redirectAttributes.addFlashAttribute("modifyResult", modifyResult);
    return "redirect:/contact/detail.do?contactNo=" + contactDto.getContactNo();
  }
  
  @RequestMapping(value="/contact/delete.do", method=RequestMethod.POST)
  public String delete(@RequestParam(value="contactNo", required=false, defaultValue="0") int contactNo, RedirectAttributes redirectAttributes) {
    int deleteResult = contactService.deleteContact(contactNo);
    redirectAttributes.addFlashAttribute("deleteResult", deleteResult);
    return "redirect:/contact/list.do";
  }
  
  @RequestMapping(value="/contact/tx.do", method=RequestMethod.GET)
  public String txTest() {
    try {
      contactService.txTest();
    } catch(Exception e) {
      return "redirect:/contact/list.do";
    }
    return null;  // 동작 안하는 코드
  }
  
}