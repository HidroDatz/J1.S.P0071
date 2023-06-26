/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package j1.s.p0071;

import common.InputOutput;
import entity.Task;
import entity.TaskType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class TaskManager {
      private List<TaskType> taskTypes;
    private List<Task> tasks;

    public TaskManager() {
        taskTypes = new ArrayList<>();
        tasks = new ArrayList<>();

        // Add pre-defined task types
        taskTypes.add(new TaskType(1, "Code"));
        taskTypes.add(new TaskType(2, "Test"));
        taskTypes.add(new TaskType(3, "Design"));
        taskTypes.add(new TaskType(4, "Review"));
    }

    public void addTask() {
        InputOutput.displayMessage("Add Task");

        int taskTypeId = InputOutput.getIntInput("Enter the Task Type ID: ");
        TaskType taskType = getTaskTypeById(taskTypeId);
        if (taskType == null) {
            InputOutput.displayMessage("Invalid Task Type ID.");
            return;
        }

        String requirement = InputOutput.getStringInput("Enter the Requirement Name: ");
        Date date = InputOutput.getDateInput("Enter the Date (dd-MM-yyyy): ");
        double planFrom = InputOutput.getTimeInput("Enter the Plan From (8.0 - 17.5): ");
        double planTo = InputOutput.getTimeInput("Enter the Plan To (8.0 - 17.5): ");
        String assignee = InputOutput.getStringInput("Enter the Assignee: ");

        Task task = new Task(taskTypeId, requirement, date, planFrom, planTo, assignee);
        tasks.add(task);

        InputOutput.displayMessage("Task added successfully.");
    }

    public void deleteTask() {
        InputOutput.displayMessage("Delete Task");

        int taskId = InputOutput.getIntInput("Enter the Task ID: ");
        Task task = getTaskById(taskId);
        if (task == null) {
            InputOutput.displayMessage("Invalid Task ID.");
            return;
        }

        tasks.remove(task);

        InputOutput.displayMessage("Task deleted successfully.");
    }

    public void showTasks() {
        InputOutput.displayMessage("Show Tasks");

        List<Task> sortedTasks = new ArrayList<>(tasks);
        sortedTasks.sort(Comparator.comparingInt(Task::getId));

        InputOutput.displayTasks(sortedTasks);
    }

    private TaskType getTaskTypeById(int id) {
        for (TaskType taskType : taskTypes) {
            if (taskType.getId() == id) {
                return taskType;
            }
        }
        return null;
    }

    private Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }
}
