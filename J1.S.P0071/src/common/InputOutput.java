/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import entity.Task;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class InputOutput {
      private static Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String prompt) {
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        return value;
    }

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static Date getDateInput(String prompt) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);

        Date date = null;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                date = dateFormat.parse(input);
                validInput = true;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter a valid date in dd-MM-yyyy format.");
            }
        }

        return date;
    }

    public static double getTimeInput(String prompt) {
        double time = 0.0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                time = Double.parseDouble(scanner.nextLine());
                if (time >= 8.0 && time <= 17.5) {
                    validInput = true;
                } else {
                    System.out.println("Invalid time. Please enter a valid time between 8.0 and 17.5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return time;
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static void displayTasks(List<Task> tasks) {
        System.out.println("--------------------------------------------------");
        System.out.println("ID\tType\tRequirement\tDate\tFrom\tTo\tAssignee");
        System.out.println("--------------------------------------------------");

        for (Task task : tasks) {
            System.out.printf("%d\t%s\t%s\t%s\t%.1f\t%.1f\t%s%n",
                    task.getId(), task.getTaskTypeId(), task.getRequirement(), task.getDate(),
                    task.getPlanFrom(), task.getPlanTo(), task.getAssignee());
        }

        System.out.println("--------------------------------------------------");
    }
}
