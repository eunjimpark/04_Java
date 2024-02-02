package edu.kh.oop.field.pack3;

public class StaticTestRun {

	public static void main(String[] args) {
		
		Korean k1 = new Korean();
		Korean k2 = new Korean();
		
		
		System.out.println("k1의 nationalCode : " + k1.nationalCode);
		System.out.println("k2의 nationalCode : " + k2.nationalCode);

		// k1을 이용해서 nationalCode 변경
		k1.nationalCode = 1;
		
		System.out.println("----- nationCode 변경 후 -----");
		System.out.println("k1의 nationalCode : " + k1.nationalCode);
		System.out.println("k2의 nationalCode : " + k2.nationalCode);

		//왜?
	}
	
}

