package com.gdu.app09.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app09.dto.ContactDto;
import com.gdu.app09.service.ContactService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j   // private static final Logger log = LoggerFactory.getLogger(ContactController.class);
@RequiredArgsConstructor
@Controller
public class ContactController {
  
  // ContactController를 실행할 때 org.sl4f.Logget가 동작한다.
 
 
  private final ContactService contactService;
  
  @GetMapping(value="/contact/list.do")
  public String list(Model model) {
    List<ContactDto> contactList = contactService.getContactList();
    model.addAttribute("contactList", contactService.getContactList());
    return "contact/list";
  }
  @GetMapping(value="/contact/write.do")
  public String write() {
    return "contact/write";
  }
  @PostMapping(value="/contact/add.do")
  public String add(ContactDto contactDto, RedirectAttributes redirectAttributes) {
    log.info("add:" + contactDto);
    int addResult = contactService.addContact(contactDto);
    redirectAttributes.addFlashAttribute("addResult", addResult);
    return "redirect:/contact/list.do";
  }
  @GetMapping(value="/contact/detail.do")
  public String detail(@RequestParam(value="contact_no", required=false, defaultValue="0")int contact_no, Model model) {
    log.info("detail:" + contact_no);
    model.addAttribute("contact", contactService.getContactByNo(contact_no));
    return "contact/detail";
  }
  @PostMapping(value="/contact/modify.do")
  public String modify(ContactDto contactDto, RedirectAttributes redirectAttributes) {
    log.info("modify:" + contactDto);
    int modifyResult = contactService.modifyContact(contactDto);
    redirectAttributes.addFlashAttribute("modifyResult", modifyResult);
    return "redirect:/contact/detail.do?contact_no=" + contactDto.getContact_no();
  }
  @PostMapping(value = "contact/delete.do")
  public String delete(@RequestParam(value="contact_no", required=false, defaultValue="0")int contact_no, RedirectAttributes redirectAttributes) {
    log.info("delete:" + contact_no);
    int deleteResult = contactService.deleteContact(contact_no);
    redirectAttributes.addFlashAttribute("deleteResult", deleteResult);
    return "redirect:/contact/list.do";
  }
} 
