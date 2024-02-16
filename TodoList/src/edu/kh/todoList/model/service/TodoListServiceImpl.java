package edu.kh.todoList.model.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kh.todoList.model.dao.TodoListDAO;
import edu.kh.todoList.model.dao.TodoListDAOImpl;
import edu.kh.todoList.model.dto.Todo;

public class TodoListServiceImpl implements TodoListService {

	// 필드
	private TodoListDAO dao = null;
	
	
	// 기본 생성자
	public TodoListServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
		dao = new TodoListDAOImpl();
	}
	
	
	
	
	
	@Override
	public Map<String, Object> todoListFullView() {
		
		// 1. 할 일 목록 DAO에서 얻어오기
		List<Todo> todoList = dao.todoListFullView();
		
		// 2. 할 일 목록에서 완료(complete 필드 값이 true)인 요소가 몇개인지
		int completeCount = 0;
		
		for(Todo todo: todoList) {
			
			if(todo.isComplete()) {
				completeCount ++;
			}
		}
		//3.todoList, completeCount를 저장할 맵 생성
		Map<String, Object> map = new HashMap<String,Object>();
		
		map.put("todoList", todoList);
		map.put("completeCount", completeCount);
		
		
		return map;
	}

	//----------------------------------------------------------------
	@Override
	public String dateFormat(LocalDateTime regDate) {
		 //yyyy-mm-dd HH:mm:ss
		// 날짜와 시간을 원하는 포맷으로 출력하기
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		//regDate에 저장되어있는 날짜데이터를 포매터에 지정된형식으로 변경
	  String formattedDateTime = regDate.format(formatter);
	  
		return formattedDateTime;
	}
	
//--------------------------------------------------------------------
	
	@Override
	public String todoDetailView(int index) {

		//1.DAO에 있는 todoList에서 index번째 요소 (Todo)반환받기 없으면 null반환
		Todo  todo = dao.todoDetailView(index);
		
		//2.반환받은 todo가 널인경우 널반환
		if(todo==null) return null;
		
		//3.todo가 참조하는 객체가 있다면문자열 가공
		
		StringBuilder sb = new StringBuilder(); 
		
		sb.append("--------------------------------------------\n");
		sb.append( String.format("제목 : %s\n", todo.getTitle()) );
		sb.append( String.format("등록일 : %s\n", dateFormat(todo.getRegDate())) );		
		sb.append( String.format("완료여부 : %s\n", todo.isComplete() ? "O" : "X") );
		sb.append("\n[세부 내용]\n");
		sb.append("--------------------------------------------\n");
		sb.append( String.format("%s\n", todo.getDetail()) );
		
		//4. 가공한 문자열을 반환
		return sb.toString();
	}
	
	//--------------------------------------------------------------------------------------

	@Override
	public int todoAdd(String title, String detail) throws FileNotFoundException, IOException {
		
		//Todo객체 생성
		Todo todo = new Todo(title, detail, false, LocalDateTime.now());

		//DAO 메서드 호출후 결과 반환 받기
		int index = dao.todoAdd(todo); //추가된 인덱스 또는 -1반환
		return index;
	}

	//---------------------------------------------------------------------------------------
	

	@Override
	public boolean todoComplete(int index) throws FileNotFoundException, IOException {
		return dao.todoComplete(index);
	}
	
	
//---------------------------------------------------------------------------------------
	
	
	@Override
	public boolean todoUpdate(int index, String title, String detail) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		return dao.todoUpdate(index, title,detail);
	}
	
	
//---------------------------------------------------------------------------------------
	
	
	@Override
	public String todoDelete(int index) throws FileNotFoundException, IOException {

		//삭제된 투두 또는 널 반환
		Todo todo = dao.todoDelete(index);
		
		if(todo ==null) return null;
		
		return todo.getTitle(); //제목반환
	}

	
	
}
