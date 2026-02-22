package ar.edu.unlp.info.oo2._Ejercicio4;

import java.time.Duration;
import java.time.LocalDateTime;

public class Paused extends State {

	public Paused(ToDoItem task) {
		super(task);
	}
	
	@Override
	public void togglePause() {
		ToDoItem task = this.getTask();
		task.changeState(new InProgress(task));
	}

	@Override
	public void finish() {
		ToDoItem task = this.getTask();
		task.changeState(new Finished(task));
	}

	@Override
	public Duration workedTime() {
		return Duration.between(this.getTask().getStartDate(), LocalDateTime.now());
	}

}
