package ksh;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOTest {

	public static void main(String[] args) {
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // 원본 데이터
		byte[] outSrc = null; // 목적지
		
		// 스트림 객체를 이용하여 inSrc에 있는 데이터를 outSrc로 전송 시켜 보자
		
		InputStream input = new ByteArrayInputStream(inSrc); // 부모이름으로 자식객체 - 다형성 
		OutputStream output = new ByteArrayOutputStream();
		
		int data = 0;
		try {
			while((data = input.read()) != -1) { // EOF(End Of File) : -1
//				System.out.println(data);
				output.write(data);
			}
		} catch (IOException e) {
			System.out.println("데이터를 읽어오지 못했습니다.");
			e.printStackTrace();
		}
		
		outSrc = ((ByteArrayOutputStream)output).toByteArray();
		
		for(byte b : outSrc) {
			System.out.println(b);
		}
		
		try {
			input.close();
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
