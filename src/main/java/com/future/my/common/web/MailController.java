package com.future.my.common.web;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.my.common.service.MailService;
import com.future.my.common.vo.MailVO;
import com.future.my.member.vo.MemberVO;

// 컨트롤로 + 비동기 사용
@Controller
@EnableAsync
public class MailController {

	@Autowired
	private MailService mailService;
	
	@RequestMapping("/sendMailDo")
	public String sendMailDo(MailVO mailVO) {
		
		System.out.println(mailVO);
		ArrayList<String> arr = mailVO.getEmail();
		for(String email : arr) {
			// arr 의 값을 email에 집어넣음
			mailService.sendMail(email, mailVO.getTitle(), mailVO.getContent());
		}
		return "home";
	}
	
	@RequestMapping("/admin")
	public String admin(HttpSession session) {
		MemberVO login = (MemberVO) session.getAttribute("login");
				if(login == null || !login.getMemId().equals("gogogo")) {
					return "home";
				}else {
					return "admin";
				}
	}
}
