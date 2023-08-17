package com.todo.etc;

import java.sql.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.todo.vo.ToDoList;

public class ResponseToJSON {
	public String makeJsonWithSimpleJson(List<ToDoList> todoList) {
		JSONObject json = new JSONObject(); // 제이슨오브젝트는 맵으로 구현됐다
		JSONArray todolist = new JSONArray();
		for (ToDoList e : todoList) {
			JSONObject toDo = new JSONObject();
			toDo.put("no", e.getNo() + "");
			toDo.put("todo", e.getTodo());
			toDo.put("end_date", e.getEnd_date().toString());
			toDo.put("complete", e.getComplete());
			
			todolist.add(toDo);
		}
		json.put("todolist", todolist);
		json.put("createdTime", new Date(System.currentTimeMillis()).toLocaleString());
		json.put("count", todoList.size() + "");
		json.put("responseCode", "00");
		json.put("responseMsg", ResponseMessageCode.getMessage("00"));

		return json.toJSONString(); // 메모리 관리를 위해 non-static한 toString메소드 사용
	}

	
}
