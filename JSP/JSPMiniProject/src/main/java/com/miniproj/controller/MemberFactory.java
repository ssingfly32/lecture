package com.miniproj.controller;

import com.miniproj.service.MemberService;
import com.miniproj.service.member.ConfirmMailCodeService;
import com.miniproj.service.member.DuplicateUserIdService;
import com.miniproj.service.member.RegisterMemberService;
import com.miniproj.service.member.SendMailService;

public class MemberFactory {
	private static MemberFactory instance = null;
	
	private MemberFactory() {}
	
	public static MemberFactory getInstance() {
		if(instance == null) {
			instance = new MemberFactory();
		}
		return instance;
	}
	
	// command를 매개변수로 받아 해당 기능을 수행하는 객체를 반환함.
	public MemberService getService(String command) {
		MemberService result = null;
		if(command.equals("/member/duplicateUserId.mem")) {
			// 아이디 중복 검사를 할 수 있는 객체를 만들어서 반환
			result = new DuplicateUserIdService();
		} else if (command.equals("/member/registerMember.mem")) {
			// 회원 가입을 할 수 있는 객체를 만들어서 반환
			result = new RegisterMemberService();
		} else if (command.equals("/member/sendMail.mem")) {
			// 인증코드를 메일로 보내는 기능을 할 수 있는 객체를 만들어서 반환
			result = new SendMailService();
		} else if (command.equals("/member/confirmCode.mem")) {
			result = new ConfirmMailCodeService();
		}
		return result;
	}
}
