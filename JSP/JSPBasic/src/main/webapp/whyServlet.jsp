<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>왜 Servlet을 사용해야 할까? (model1 방식 코딩)</title>
</head>
<body>
	<!-- 
		정수 값을 주고, 그 값이 홀수이면 파란색 h3태그로 "홀수"라고 출력하고, 
		그 값이 짝수이면 빨간색 h3 태그로 "짝수"라고 출력하는 프로그램을 작성해 보자
	 -->
	 
	 <% 
	 	// 아래의 코드는 웹 서버에서 실행되어! 결과만을 클라이언트에 전송한다.
	 	// 때문에, 클라이언트에서 이 문서를 보면 자바의 문법을 확인할 수 없다.
	 	
	 	
	 	out.println("<div>!</div>");
	 
	 	int num = 5;
	 	if(num % 2 == 0) {
	 %>		
	 		<div style='color : red;'>짝수</div>
	 	
	 <% 
	 	} else if(num % 2 != 0) {
	  %>
	 		<div style='color : blue;'>홀수</div>
	  <%		
	 	}
	 	
	 	// 위 코드는 model1 방식(모든 코드를 jsp파일에 넣는)으로 코딩된 코드이다. 
	 	// (간단한 프로그래밍임에도 불구하고, 구조가 복잡하다.)
	 	// -> 개발도 어렵고, 유지보수도 어렵다. -> model2(MVC 패턴으로 가자)
	 %>
</body>
</html>