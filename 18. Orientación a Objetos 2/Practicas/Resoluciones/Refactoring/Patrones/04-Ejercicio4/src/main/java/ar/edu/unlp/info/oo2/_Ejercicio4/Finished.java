package ar.edu.unlp.info.oo2._Ejercicio4;

import java.time.Duration;

public class Finished extends State{

	public Finished(ToDoItem task) {
		super(task);
		this.getTask().setEndDate();
	}
	
	@Override
	public void togglePause() throws RuntimeException {
		throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
	}
	
	@Override
	public Duration workedTime() {
		return Duration.between(this.getTask().getStartDate(), this.getTask().getEndDate());
	}

	@Override
	public void addComment(String comment) {}

}
