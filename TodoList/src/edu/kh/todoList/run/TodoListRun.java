package edu.kh.todoList.run;

import edu.kh.todoList.view.TodoListView;

public class TodoListRun {

	public static void main(String[] args) {
		//현재프로젝트의 흐름
		//Run <-> View <->Service <-> DAO <->File
		
		System.out.println("----- 프로그램실행 -----");
		
		TodoListView view = new TodoListView();
		
		view.startView();
		
		
	}
}
