<!-- 페이지 지시자 : 현재 페이지에 대한 환경 설정 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%! // 선언부
	String str = "안녕하세요!"; // 멤버 변수로 선언

	public int abs(int n) { // 멤버 메서드가 됨
		if (n < 0) {
			n = -n;
		}
		return n;
	}
	%>


	<%
	// 스크립트릿 내부에서 선언되는 변수는 지역변수 취급
	int num = 3;
	out.print("<div>" + num + "</div>");
	out.print("<div>" + this.str +"</div>");
	out.print("<div>" + this.abs(-3) +"</div>");
	%>
	
	<span><%=str %></span>
	<div><%=abs(-5000) %></<div>>
</body>
</html>