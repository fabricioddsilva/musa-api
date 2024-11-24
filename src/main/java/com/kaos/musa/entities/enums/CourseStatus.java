package com.kaos.musa.entities.enums;

public enum CourseStatus {
    ANDAMENTO("andamento"),
    COMPLETO("completo");

    private String courseStatus;

    CourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getCourseStatus() {
        return courseStatus;
    }
}
