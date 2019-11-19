package com.swclass;

public class Todo {
	private String todo;
	private String date;
	private String text;
	private int textNo;
	
	Todo(int textNo ,String todo, String text, String date){
		this.textNo = textNo;
		this.todo = todo;
		this.text = text;
		this.date = date;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "Todo [todo=" + todo + ", date=" + date + ", text=" + text + ", textNo=" + textNo + "]";
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getTextNo() {
		return textNo;
	}

	public void setTextNo(int textNo) {
		this.textNo = textNo;
	}


}
