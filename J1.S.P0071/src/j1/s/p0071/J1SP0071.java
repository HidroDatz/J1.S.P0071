/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package j1.s.p0071;

import common.InputOutput;

/**
 *
 * @author ASUS
 */
public class J1SP0071 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = InputOutput.getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    taskManager.addTask();
                    break;
                case 2:
                    taskManager.deleteTask();
                    break;
                case 3:
                    taskManager.showTasks();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    InputOutput.displayMessage("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void displayMenu() {
        InputOutput.displayMessage("----- Task Management System -----");
        InputOutput.displayMessage("1. Add Task");
        InputOutput.displayMessage("2. Delete Task");
        InputOutput.displayMessage("3. Show Tasks");
        InputOutput.displayMessage("4. Exit");
    }

}
