package edu.kh.collection.pack3.model.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import edu.kh.collection.pack2.model.dto.Person;

import java.util.Set;


public class MapService {

	
	/* Map : 특정 키워드(Key)를 입력하면
	 *       해당되는 상세한 값(Value)를 얻을 수 있는 컬렉션 객체
	 * 
	 * - K:V 형식으로 구성
	 * 
	 * - K:V 한 쌍을 "Entry" 라고 부름
	 * 
	 * - Key : 키워드 역할(== 변수명)
	 * 1) 중복 X
	 *  -> 중복되는 Key 입력 시 Value를 덮어씌움
	 *  -> Key 역할의 객체는 hashCode(), equals() 오버라이딩 필수!
	 *  
	 * 2) 순서 유지 X (단, LinkedHashMap 제외)
	 * 
	 * * Key만 묶어서 보면 Set과 같은 특징을 지니고 있음!
	 *  -> Map.keySet() / Map.EntrySet() 제공
	 * 
	 * 
	 * Value : 키워드에 해당하는 상세한 값
	 * 
	 * - Key로 인해서 모든 Value가 구분됨
	 *  -> Map.get(Key) / Map.remove(Key) 형태로 사용
	 * 
	 */
	
	public void method1() {
		//HashMap 생성
		Map<Integer,String> map =new HashMap<Integer, String>();
		
		//1. V put(K k, V v) Map에 추가
		System.out.println(map.put(1,"에그마요"));
		System.out.println(map.put(2,"로티세리바베큐"));
		System.out.println(map.put(3,"스테이크앤치즈"));
		System.out.println(map.put(3,"스파이시쉬림프"));
		
		
		System.out.println(map);
		
		
		//2. V get(K k) : K에 해당되는 Value반환
		
		System.out.println(map.get(1)); //에그마요
		System.out.println(map.get(0)); //null
		
		String temp1 = map.get(2);
		System.out.println(temp1);
		
		//3.int size() : Map 에 저장된 엔트리의 갯수
		System.out.println("size :" + map.size() );
		
		// 4.  V remove(K k) :
		// - Key가 일치하는 Entry를 제거
		// - 일치하는 Key가 있다면 Value, 없다면 null 반환
		
		System.out.println("---------------------------------");
		System.out.println("remove(2) : " + map.remove(2));
		System.out.println("remove(5) : " + map.remove(5));
		System.out.println(map);
		
		//5. void clear() : 모든엔트리 삭제
		
		//6. boolean isEmpty() : 비어있는지 참/거짓
		
		System.out.println("clear()전 is EMpty():" + map.isEmpty() );
		
		map.clear();
		System.out.println("clear()후 is EMpty():" + map.isEmpty() );
		
	}

	
	public void method2() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("학원", "서울시 중구");
		map.put("집", "서울시 관악구");
		map.put("롯데타워", "서울시 송파구");
		map.put("63빌딩", "서울시 영등포구");
		
		Set<String> set = map.keySet();
		
		System.out.println("keyset : " +set);
		
		//향상된 for문 + set
		for(String key :set) {
			System.out.printf("%-10s :%s \n", key, map.get(key));
		}
		
	}
	
	
	//맵요소 엔트리 순차접근하기
	public void method3() {
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("학원", "서울시 중구");
		map.put("집", "서울시 관악구");
		map.put("롯데타워", "서울시 송파구");
		map.put("63빌딩", "서울시 영등포구");
		
		Set<Entry<String,String>> entrySet = map.entrySet();
		
		for(Entry<String, String> entry : entrySet) {
			System.out.printf("key : %s, value: %s \n",  entry.getKey() , entry.getValue());
			
		}
		
	}
	
	
	public void method4() {
		
		
		 Person p1 = new Person();
		 p1.setName("홍길동");
		 p1.setAge(25);
		 p1.setGender('남');
		 
		 System.out.printf("이름 : %s, 나이: %d, 성별 :%c \n ",
				 p1.getName(), p1.getAge(), p1.getGender());
		 
		 System.out.println("----------------------------------------");
		 
			// DTO 대신 Map 활용하기
			// - Key는 무조건 String을 활용하는게 Best
			// - Value의 타입이 모두 다름
			//   -> Object를 부모 타입 참조 변수로 활용
			//   --> 다형성( 업캐스팅 + 동적 바인딩 )
			
			Map<String , Object> p2 = new HashMap<String, Object>();
			//데이터추가
			p2.put("naeme", "김길순");
			p2.put("age", 22);
			p2.put("gender", '여');
			
			//데이터 얻어오기
			System.out.printf("이름: %s, 나이: %d, 성별: %d \n",
					p2.get("name"), p2.get("age"), p2.get("gender"));

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
