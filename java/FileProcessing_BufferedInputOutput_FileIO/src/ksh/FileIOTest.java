package ksh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class FileIOTest {
	public static void main(String[] args) {
		String inputFilePath = "D:\\lecture\\java\\ArrayEx1\\src\\ksh\\ArrayEx1.java"; // 역슬래시 두개를 써야 역슬래시 하나로 인식.
		// 웹서버에서는 절대경로 지양.
		String outputFilePath = "D:\\lecture\\copyKsh.txt";
		
		File tmp = new File(inputFilePath);
		System.out.println(tmp.exists());
		FileInputStream fis = null; // 입출력 시엔 선언과 생성을 분리해서 하는것이 일반적
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(inputFilePath); // 1바이트씩밖에 못읽음
			fos = new FileOutputStream(outputFilePath);
		} catch (FileNotFoundException e) {
			System.out.println("그런 파일 없습니다.");
			System.exit(0);
			e.printStackTrace();
		}
		InputStreamReader rd = null;
		OutputStreamWriter osw = null; 
		try {
			rd = new InputStreamReader(fis,"utf-8");
			osw = new OutputStreamWriter(fos, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(rd); // 조합할수 있는 버퍼 - 리더 달라고해서 리더 줘야됨
		BufferedWriter bw = new BufferedWriter(osw);
		String data = null;
		try {
			while((data = br.readLine()) != null) {
				System.out.println(data);
				bw.write(data);
				bw.write("\n");
			}
			br.close();
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
