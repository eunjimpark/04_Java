package edu.kh.io.pack4.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterService {

	/* 문자 기반 스트림
	 * 
	 * - 2byte 문자(char) 단위로 입/출력 하는 스트림
	 * 
	 * - Reader(입력), Writer(출력) 최상위 인터페이스
	 * 
	 * - 문자만 작성된 파일, 채팅, 인터넷 요청 시 데이터 전달
	 */
	
	
	/**
	 * 문자 기반 파일 입력(파일 읽어오기)
	 *  + 보조 스트림 Buffered 사용
	 */
	public void fileInput() {
			
		FileReader fr = null;  //문자기반 파일 입력 스트림
		BufferedReader br = null; //문자기반 보조스트림
			
		try {
			fr = new FileReader("/io_test/노래가사2.txt");
			
			//보조 스트림 생성
			br = new BufferedReader(fr);
			
			//br.readLine()
			
			String line = null; //한줄을 읽어와 저장할 변수
			
			while(true) {
				line = br.readLine();
				if(line==null) {
					break;
				}
				System.out.println(line); //읽어온 내용있으면 콘솔에출력
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//사용완료된 스트림객체를 메모리반환
		}	
	}
	
	
	
	
	public void fileOutput() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("오늘은 2월 16일 금요일 입니다.\n");
		sb.append("벌써 금요일이라니! 기부니가 좋군요!\n");
		sb.append("다들 힘내서 공부합시다\n");
		sb.append("(지켜보고있다...............)");
		
		String content = sb.toString();
		
		//content에 저장된 문자열을 io_test/출력테스트.txt로 출력하기
		
		FileWriter fw = null; 
		BufferedWriter bw = null;
		
		try {
			//파일이 없으면 생성됨
			fw= new FileWriter("/io_test/출력테스트.txt");
			bw= new BufferedWriter(fw); //버퍼이용해서 성능향상

			bw.write(content);
			
			//bw.flush();

			System.out.println("출력완료");
		}
		
		catch(IOException e) {
			e.printStackTrace();
		}	
		
		finally {
			try {
				if(bw != null) bw.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
			
	}	
		


		

	
	
	
	
	
	
}
