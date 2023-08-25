package com.miniproj.controller;

import com.miniproj.service.MemberService;

import com.miniproj.service.member.ChangeImageService;
import com.miniproj.service.member.ConfirmMailCodeService;
import com.miniproj.service.member.DefaultImageService;
import com.miniproj.service.member.DuplicateUserIdService;
import com.miniproj.service.member.LoginMemberService;
import com.miniproj.service.member.LogoutMemberService;
import com.miniproj.service.member.MyPageService;
import com.miniproj.service.member.RegisterMemberService;
import com.miniproj.service.member.SendMailService;
import com.miniproj.service.member.UpdateEmailService;
import com.miniproj.service.member.ViewDetailTotalPoint;

public class MemberFactory {
	private static MemberFactory instance = null;
	
	private boolean isRedirect;	// redirect 할 것인지 말 것인지
	private String whereIsGo;	// 어느 view단으로 이동할 것인지
	
	private MemberFactory() {}
	
	public static MemberFactory getInstance() {
		if(instance == null) {
			instance = new MemberFactory();
		}
		return instance;
	}
	
	
	
	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getWhereIsGo() {
		return whereIsGo;
	}

	public void setWhereIsGo(String whereIsGo) {
		this.whereIsGo = whereIsGo;
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
		} else if (command.equals("/member/login.mem")) {
			result = new LoginMemberService();
		} else if (command.equals("/member/logout.mem")) {
			result = new LogoutMemberService();
		} else if (command.equals("/member/myPage.mem")) {
			result = new MyPageService();
		} else if (command.equals("/member/defaultImage.mem")) {
			result = new DefaultImageService();
		} else if (command.equals("/member/updateEmail.mem")) {
			result = new UpdateEmailService();
		} else if (command.equals("/member/changeImage.mem")) {
			result = new ChangeImageService();
		} else if (command.equals("/member/detailTotalPoint.mem")) {
			result = new ViewDetailTotalPoint();
		}
		return result;
	}
}
