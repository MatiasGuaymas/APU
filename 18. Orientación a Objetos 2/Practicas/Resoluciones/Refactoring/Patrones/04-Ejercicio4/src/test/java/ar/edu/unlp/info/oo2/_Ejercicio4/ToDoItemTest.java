package ar.edu.unlp.info.oo2._Ejercicio4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ToDoItemTest {
    private ToDoItem taskSinIniciar;
    private ToDoItem taskInProgress;
    private ToDoItem taskPaused;
    private ToDoItem taskFinished;

    @BeforeEach
    void setUp() throws Exception {
        taskSinIniciar = new ToDoItem("task 1");
        taskInProgress = new ToDoItem("task 2");
        taskPaused = new ToDoItem("task 3");
        taskFinished = new ToDoItem("task 4");
        
        taskInProgress.start();
        taskPaused.start();
        taskPaused.togglePause();
        taskFinished.start();
        taskFinished.finish();
    }

    // Tests para taskSinIniciar (Pending)
    @Test
    void testTaskSinIniciarStart() {
        taskSinIniciar.start();
        assertTrue(taskSinIniciar.getState() instanceof InProgress);
    }
    
    @Test
    void testTaskSinIniciarFinish() {
        taskSinIniciar.finish();
        assertTrue(taskSinIniciar.getState() instanceof Pending);
    }
    
    @Test
    void testTaskSinIniciarWorkedTime() {
        assertThrows(RuntimeException.class, () -> taskSinIniciar.workedTime());
    }
    
    @Test
    void testTaskSinIniciarAddComment() {
        taskSinIniciar.addComment("hola");
        assertEquals(1, taskSinIniciar.getComments().size());
    }
    
    @Test
    void testTaskSinIniciarTogglePause() {
        assertThrows(RuntimeException.class, () -> taskSinIniciar.togglePause());
    }

    // Tests para taskInProgress (InProgress)
    @Test
    void testTaskInProgressStart() {
        taskInProgress.start();
        assertTrue(taskInProgress.getState() instanceof InProgress);
    }
    
    @Test
    void testTaskInProgressFinish() {
        taskInProgress.finish();
        assertTrue(taskInProgress.getState() instanceof Finished);
    }
    
    @Test
    void testTaskInProgressTogglePause() {
        taskInProgress.togglePause();
        assertTrue(taskInProgress.getState() instanceof Paused);
    }
    
    @Test
    void testTaskInProgressAddComment() {
        taskInProgress.addComment("hola");
        assertEquals(1, taskInProgress.getComments().size());
    }
    
    // Tests para taskPaused (Paused)
    @Test
    void testTaskPausedStart() {
        taskPaused.start();
        assertTrue(taskPaused.getState() instanceof Paused);
    }
    
    @Test
    void testTaskPausedFinish() {
        taskPaused.finish();
        assertTrue(taskPaused.getState() instanceof Finished);
    }
    
    @Test
    void testTaskPausedTogglePause() {
        taskPaused.togglePause();
        assertTrue(taskPaused.getState() instanceof InProgress);
    }
    
    @Test
    void testTaskPausedAddComment() {
        taskPaused.addComment("hola");
        assertEquals(1, taskPaused.getComments().size());
    }
    
    // Tests para taskFinished (Finished)
    @Test
    void testTaskFinishedStart() {
        taskFinished.start();
        assertTrue(taskFinished.getState() instanceof Finished);
    }
    
    @Test
    void testTaskFinishedFinish() {
        taskFinished.finish();
        assertTrue(taskFinished.getState() instanceof Finished);
    }
    
    @Test
    void testTaskFinishedAddComment() {
        taskFinished.addComment("hola");
        assertEquals(0, taskFinished.getComments().size());
    }
    
    @Test
    void testTaskFinishedTogglePause() {
        assertThrows(RuntimeException.class, () -> taskFinished.togglePause());
    }
}