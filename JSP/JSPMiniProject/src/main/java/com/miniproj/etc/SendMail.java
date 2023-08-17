package com.miniproj.etc;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class SendMail {

	public static void sendMail(String userMailAddr, String code) throws AddressException, MessagingException {
		
		// SMTP(Send Mail Transfer Protocol) : 메일 전송 통신 규약 
		
		Properties props = new Properties();
		
		String subject = "miniproj.com에서 보낸 이메일 인증번호입니다";
		String message = "miniproj.com 회원 가입을 환영합니다. 회원 가입 화면에서 인증번호 : " + code + "를 입력하시고 코드 확인 버튼을 눌러"
				+ "회원 가입을 완료하세요.";
		
		// gmail 서버에 따르는 SMTP 환경 설정
		props.put("mail.smtp.starttls.required", "true");	// 메일 서버 환경 설정 시작
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");	// 사용될 ssl 보안 프로토콜 설정
		props.put("mail.smtp.host", "smtp.naver.com");	// smtp 서버호스트 이름
		props.put("mail.smtp.port", "465");	// smtp 포트 번호
		props.put("mail.smtp.auth", "true");	// 인증 과정을 거치겠다.
		props.put("mail.smtp.ssl.enable", "true"); // ssl 사용
		
		// 구글 서버에 로그인 하여 인증 얻기
		Session mailSession = Session.getDefaultInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(EmailAccount.emailAddr, EmailAccount.emailPwd);
			}
			
		});
		
		System.out.println(mailSession.toString());
		if(mailSession != null) {
			MimeMessage mime = new MimeMessage(mailSession);
			mime.setFrom(new InternetAddress("ssingfly@naver.com"));	// 보내는 메일 주소
			mime.addRecipient(RecipientType.TO, new InternetAddress(userMailAddr));	// 받는 사람
			mime.setSubject(subject);	// 제목
			mime.setText(message, "utf-8");	// 본문
			
			Transport trans = mailSession.getTransport("smtp");
			trans.connect(EmailAccount.emailAddr, EmailAccount.emailPwd);
			trans.sendMessage(mime, mime.getAllRecipients()); // 발송
			trans.close();
		}
	}

}
