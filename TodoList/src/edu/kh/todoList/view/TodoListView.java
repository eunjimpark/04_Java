package edu.kh.todoList.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dto.Todo;
import edu.kh.todoList.model.service.TodoListService;
import edu.kh.todoList.model.service.TodoListServiceImpl;

//view 보여지는 부분 역할
public class TodoListView {

	//필드
	 private TodoListService service = null;
	 private BufferedReader br = null;
	 
	 //기본생성자
	 public TodoListView() {

		 try {
			 //부모타입 참조변수 = 자식객체
			 service = new TodoListServiceImpl();
			 
			 br=new BufferedReader(new InputStreamReader(System.in));
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
	 }
	 
	 //--------------------------------------------------------------------------------
	 
	 //todolist프로그램 시작화면
	 public void startView() {
		 int input = 0;
		 do {
			 
			 try {//선택한 번호가 반환되어 인풋에 저장
				 input = selectMenu();
				 
					switch (input) {
					case 1: todoListFullView(); break; 
					case 2: todoDetailView(); break; 
					case 3: todoAdd(); break; 
					case 4: todoComplete(); break; 
					case 5: todoUpdate(); break; 
					case 6: todoDelete(); break; 
					
					case 0: System.out.println("@@@ 프로그램 종료 @@@"); break; 
					default: System.out.println("### 메뉴에 작성된 번호만 입력해 주세요 ###");
					}
					
					System.out.println("===========================================");
					
				 
			 }catch(NumberFormatException e){
				 System.out.println("숫자만 입력해 주세요###");
				 input = -1; //첫반복에 종료되는걸 방지
			 }catch(IOException e) {
				 System.out.println("입/출력 관련 예외 발생###");
				 e.printStackTrace();
			 }catch(Exception e) { //기타예외모두처리
				 e.printStackTrace();
			 }
		 }while(input !=0);
		 
	 }
	 
	 
//-----------------------------------------------------------------------------------
	private void todoListFullView() {
		System.out.println("\n===============[1. Todo List Full View]===============\n");
		
		// 할 일 목록 + 완료된 개수 카운트한 값 얻어오기
		Map<String, Object> map =  service.todoListFullView();

		//반환 받은 map요소 뜯어내기
		List<Todo> todoList = (List<Todo>)map.get("todoList") ;
		int completeCount = (int)map.get("completeCount");
		
		//출력
		
		System.out.printf("[ 완료된 Todo 개수 / 전체 Todo 수 : %d / %d ]\n"
				, completeCount, todoList.size());

		System.out.println("--------------------------------------------------------------------");
		System.out.printf("%-3s %10s   %10s     %s\n", "인덱스", "등록일", "완료여부", "할 일 제목");
		System.out.println("--------------------------------------------------------------------");
		
		for(int i=0, len = todoList.size(); i < len; i++) {
			String title = todoList.get(i).getTitle();
			String completeYN = todoList.get(i).isComplete() ? "O" : "X";
			String regDate = service.dateFormat(todoList.get(i).getRegDate());
			System.out.printf("[%3d]  %20s    (%s)       %s\n", i, regDate, completeYN, title);
		
		}
	}
	
	//--------------------------------------------------------------------

	private void todoDetailView() throws NumberFormatException, IOException {
		System.out.println("\n======================[2.Todo Detail View]======================\n");
		
		System.out.print("인덱스 번호 입력:");
		int index = Integer.parseInt(br.readLine());
		
		//할일 상세조회 서비스 호출후 결과 반환 받기
		String todoDetail = service.todoDetailView(index);
		
		if(todoDetail ==null) {
			System.out.println("###입력한 인덱스 번호가 존재하지 않습니다 ###");
			return;
		}	
		System.out.println(todoDetail);  //상세내용출력
		
	}
	
	//-----------------------------------------------------------------------
	
  //할일추가 상세내용만 입력받음
	private void todoAdd() throws IOException {
		System.out.println("\n===============[3. Todo Add]===============\n");

		System.out.print("할 일 제목 입력:");
		String title = br.readLine();
		
		System.out.println("세부내용 작성(입력 종료시 !wq 작성후 엔터)");
		System.out.println("---------------------------------");

		StringBuilder sb = new StringBuilder();
		
		while (true) {

			//문자열 입력받기
			String content = br.readLine();
			
			if(content.equals("!wq")) break;
		
			sb.append(content);
			sb.append("\n");     //입력값누적 +줄바꿈추가			
		}		
		System.out.println("---------------------------------");
		
		//할일 추가 서비스 호출 후 결과 반환하기
		//성공 : 추가된 인덱스 , 실패: -1
		int index = service.todoAdd(title, sb.toString());
		
		if(index ==-1) {//실패
			System.out.println("###추가실패###");
			return;
		}
		//성공
		System.out.printf("[%d]인덱스에 추가 되었습니다.\n",index);
	}

	//-----------------------------------------------------------------------
	
	
	private void todoComplete() throws NumberFormatException, IOException {
		System.out.println("\n===============[4. Todo Complete]===============\n");
		System.out.print("O<->X 변경할 인덱스 번호 입력:");
		int index = Integer.parseInt(br.readLine());
		
		//서비스 호출하고 결과(T/F)반환받기
		boolean result = service.todoComplete(index);
		
		if(result) { //변경성공
			
			System.out.println("[변경 되었씁니다]");
		}else { //인덱스요소가 범위초과
			System.out.println("###인덱스가 존재하지 않습니다 ###");
		}
	}
	

//-----------------------------------------------------------------------
	
	
	private void todoUpdate() throws NumberFormatException, IOException {
		System.out.println("\n===============[5. Todo Update]===============\n");
		
		System.out.print("수정할 인덱스 번호 입력 :");
		int index = Integer.parseInt(br.readLine());
		
		String todoDetail = service.todoDetailView(index);
		if(todoDetail ==null) {
			System.out.println("###인덱스가 존재하지 않습니다###");
			return;
		}
		//수정전 상세 내용 출력 
		System.out.println("@@@@@@@@@@@@@[수정전]@@@@@@@@@@@@@");
		System.out.println(todoDetail);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		
		//수정할 제목, 내용 입력 받기
		System.out.print("수정할 제목 입력:");
		String title = br.readLine();
		
		System.out.println("수정할 세부내용 작성(입력 종료시 !wq 작성후 엔터)");
		System.out.println("---------------------------------");

		StringBuilder sb = new StringBuilder();
		
		while (true) {

			//문자열 입력받기
			String content = br.readLine();
			
			if(content.equals("!wq")) break;
		
			sb.append(content);
			sb.append("\n");     //입력값누적 +줄바꿈추가			
		}		
		System.out.println("---------------------------------");
		//수정서비스 호출 후 결과 반환 받기
		boolean result = service.todoUpdate(index, title, sb.toString());
		
		if(result) System.out.println("[수정 되었씁니다]");
		else       System.out.println("###수정실패###");
	}
	
	
//-----------------------------------------------------------------------
	

	private void todoDelete() throws NumberFormatException, IOException {
		System.out.println("\n===============[6. Todo Delete]===============\n");
		System.out.print("삭제할 인덱스 번호 입력");
		
		int index = Integer.parseInt(br.readLine());
		
		//삭제 서비스 호출 후 결과 반환 받기	
		String title = service.todoDelete(index);
		if(title == null) System.out.println("###인덱스가 존재하지 않습니다###");
		else              System.out.printf("[%s]가 삭제 되었습니다\n",title);
		
	}


	// ------------------------------------------------------------------------------------------------------
	
	
	/** 메뉴 출력 및 선택
	 * @return 선택한 메뉴 번호 반환
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	private int selectMenu() throws NumberFormatException, IOException {

		System.out.println("\n====== Todo List =====\n");
		
		System.out.println("1. Todo List Full View");
		System.out.println("2. Todo Detail View");
		System.out.println("3. Todo Add");
		System.out.println("4. Todo Complete");
		System.out.println("5. Todo Update");
		System.out.println("6. Todo Delete");
		System.out.println("0. EXIT");
		
		System.out.print("select menu number >>> ");
		
		
		int input = Integer.parseInt(br.readLine());
		System.out.println();
		
		return input;
	}

	
	// ----------------------------------------------------
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
