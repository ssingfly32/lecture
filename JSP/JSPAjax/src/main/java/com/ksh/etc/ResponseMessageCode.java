package com.ksh.etc;

import java.util.HashMap;
import java.util.Map;

public class ResponseMessageCode {
	private static Map<String, String> responseStatus = new HashMap<String, String>();
	
	static {
		responseStatus.put("00", "OK");
		responseStatus.put("01", "DB서버에 문제가 있습니다.");
		responseStatus.put("02", "PK 제약조건 위반");
		responseStatus.put("03", "FK 제약조건 위반");
		responseStatus.put("04", "해당 사번을 가진 직원이 존재하지 않습니다.");
		
	}
	
	public static String getMessage(String code) {
		return responseStatus.get(code);
	}
}
