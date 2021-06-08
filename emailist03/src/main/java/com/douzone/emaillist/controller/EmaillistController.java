package com.douzone.emaillist.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.emaillist.repository.EmaillistRepository;
import com.douzone.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {
	
	
	
	
	
	@Autowired
	private EmaillistRepository emaillistRepository;
	
	
	
   @RequestMapping("")
   public String index (Model modle) {
	   List <EmaillistVo> list = new  EmaillistRepository().findAll();
	   modle.addAttribute("list",list);
	   return"/WEB-INB/views/index.jsp";
	   
   }
   @RequestMapping("/form")
   public  String form() {
	   return "/WEB-INF/views/form.jsp";
	   
   }
   @RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(EmaillistVo vo) {
		emaillistRepository.insert(vo);
		return "redirect:/";
	}

   
}
