package com.hcc.enums;



import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AssignmentEnum {
    ASSIGNMENT_1(1, "Hello World"),
    ASSIGNMENT_2(2, "Build the snake game"),
    ASSIGNMENT_3(3, "Hangman"),
    ASSIGNMENT_4(4, "Using AWS Lambda"),
    ASSIGNMENT_5(5, "Update your github profile"),
    ASSIGNMENT_6(6, ""),
    ASSIGNMENT_7(7, "");
    private int assignmentNumber;
    private String assignmentName;

    AssignmentEnum (int assignmentNumber, String assignmentName) {
        this.assignmentNumber = assignmentNumber;
        this.assignmentName = assignmentName;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public int getAssignmentNumber() {
        return assignmentNumber;
    }

}
