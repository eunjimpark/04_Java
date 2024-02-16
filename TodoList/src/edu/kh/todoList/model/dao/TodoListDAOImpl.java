package edu.kh.todoList.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.kh.todoList.model.dto.Todo;

public class TodoListDAOImpl implements TodoListDAO {
	
	//필드
	private final String FILE_PATH = "/io_test/TodoList.dat";
	
	private List<Todo> todoList = null;
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	//기본생성자
	public TodoListDAOImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		//객체생성시 TodoList.dat파일 내용 읽어오기;
		//->읽어오기전에 있는지 검사부터!!!
		File file = new File(FILE_PATH);
		if(file.exists()) { //파일이존재하면
			try {
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
				
				//읽어온 객체를 arraylislt로 강제형변환 다운캐스팅
				todoList = (ArrayList<Todo>)ois.readObject();
			} finally {	
				if(ois !=null) ois.close();
			}
			System.out.println("데이터 읽어오기 완료*** ");
			
		}else { //파일존재X
			//폴더,파일 만들기
			File directory = new File ("/io test");
			
			if(!directory.exists()) directory.mkdir(); //없으면 생성
			
			//file.createNewFile();
			
			//객체출력스트림을 이용해서 파일 생성 + 샘플데이터 추가
			todoList = new ArrayList<Todo>();
			
			todoList.add(new Todo("자바 공부","수업내용 복습하기", false, LocalDateTime.now()));
			todoList.add(new Todo("CSS 공부","수업내용 복습하기", false, LocalDateTime.now()));
			todoList.add(new Todo("HTML 공부","수업내용 복습하기", false, LocalDateTime.now()));
			
			try {
				//객체 출력 스트림 생성
				oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
				oos.writeObject(todoList); //todolist를 파일로 출력
				
			}finally {
				oos.close();
			}
			System.out.println("Todolist.dat.파일 생성 완료***");

		}
	}
	
	
	
	
	
	

	@Override
	public void saveFile() throws FileNotFoundException, IOException {
		try {
			// FILE_PATH
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			
			oos.writeObject(todoList);
		}finally {
			oos.close();
		}
		
	}
	
	
//---------------------------------------------------------------
	
	@Override
	public List<Todo> todoListFullView() {
		// TODO Auto-generated method stub
		return todoList;
	}
	
	
	//-------------------------------------------------------

	
	@Override
	public Todo todoDetailView(int index) {

		//1. index범위가 todoList 범위를 넘어서면 null반환
		if(index<0||index>=todoList.size()) return null;
		
		//2. index가 정상범위면 index번째 요소 반환
		return todoList.get(index);
	}
	
	
	//-----------------------------------------------------------

	
	@Override
	public int todoAdd(Todo todo) throws FileNotFoundException, IOException {
		//todollislt 에 전달받은todo를 추가 ->성공시 파일에 저장후 삽입된 index반환
		//추가 실패시 -1반환
		
		if(todoList.add(todo)){ //추가성공
			//파일저장
			saveFile(); 
			
			//삽입된 인덱스 반환
			return todoList.size() -1;
		}
		return -1; //추가실패
	}
	
	
	//-----------------------------------------------------------
	
	
	@Override
	public boolean todoComplete(int index) throws FileNotFoundException, IOException {
		//1. index범위 초과시 false반환
		if(index < 0 || index>=todoList.size()) return false;
		
		//2. 인덱스가 정상범위인경우 인덱스번째 요소의 complete 값을 변경하고 파일 저장후 
		//true 반환
		boolean complete = todoList.get(index).isComplete();
		
		todoList.get(index).setComplete(!complete);
		saveFile(); //파일저장
		
		return true;
	}
	
	
	//-----------------------------------------------------------
	
	
	@Override
	public boolean todoUpdate(int index, String title, String detail) throws FileNotFoundException, IOException {
		//수정된 제목, 내용을 이용해서 Todo객체 생성
		Todo todo = new Todo();
		todo.setTitle(title);
		todo.setDetail(detail);
		
		//index 번째 요소의 complete, regDate 값을 얻어와 todo에 셋팅
		todo.setComplete(todoList.get(index).isComplete());
		todo.setRegDate (todoList.get(index).getRegDate());
		
		//E e List.set(int index, E e) : index번째 요소를 매개변수 e로 바꾸고 이전요소반환
		if(todoList.set(index, todo) !=null) { //수정 성공
			saveFile(); //변경된 todo저장
			return true;
		}
		return false;
	}
	
	
	//-----------------------------------------------------------
	@Override
	public Todo todoDelete(int index) throws FileNotFoundException, IOException {
		
		//인덱스 범위 검사
		if(index <0 || index >=todoList.size()) return null;
		
		//todoList에서 index 번째 요소 삭제 후 저장 
		Todo todo = todoList.remove(index);
		saveFile();
		
		return todo;
	}
	
	

}
