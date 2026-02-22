package ar.edu.unlp.info.oo2._Ejercicio4;

import java.time.Duration;

public abstract class State {
	private ToDoItem task;
	
	public State (ToDoItem task) {
		this.task = task;
	}
	
	public ToDoItem getTask() {
		return this.task;
	}
	
	public void start() {};
	
	public abstract void togglePause();
	
	public void finish() {};
	
	public abstract Duration workedTime();
	
	public void addComment(String comment) {
		this.task.getComments().add(comment);
	};
}
