/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Task {
    private static int lastId = 0;

    private int id;
    private int taskTypeId;
    private String requirement;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assignee;

    public Task(int taskTypeId, String requirement, Date date, double planFrom, double planTo, String assignee) {
        this.id = ++lastId;
        this.taskTypeId = taskTypeId;
        this.requirement = requirement;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assignee = assignee;
    }

    public int getId() {
        return id;
    }

    public int getTaskTypeId() {
        return taskTypeId;
    }

    public String getRequirement() {
        return requirement;
    }

    public Date getDate() {
        return date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public String getAssignee() {
        return assignee;
    }
}
