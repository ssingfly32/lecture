package com.webshjin.etc;

import java.util.HashMap;
import java.util.Map;

public class ResponseMessageCode {
	private static Map<String, String> responseStatus = new HashMap<String, String>();
	
	static {
		responseStatus.put("00", "OK");
		responseStatus.put("01", "DB서버에 문제가 있습니다");
		responseStatus.put("02", "PK제약조건 위반");
		responseStatus.put("03", "FK제약조건 위반");
		responseStatus.put("100", "잘못된 api키입니다");
	}
	
	public static String getMessage(String code) {
		return responseStatus.get(code);
	}
}
