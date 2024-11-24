package com.kaos.musa.entities;

import com.kaos.musa.entities.enums.CourseStatus;
import com.kaos.musa.entities.pk.CourseProgressPK;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "course_progress")
public class CourseProgress implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CourseProgressPK id = new CourseProgressPK();

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "course_status", nullable = false)
    private CourseStatus status;

    public CourseProgress() {
    }

    public CourseProgress(User user, Course course, LocalDateTime startDate, CourseStatus status) {
        id.setUser(user);
        id.setCourse(course);
        this.startDate = startDate;
        this.status = status;
    }

    public User getUser(){
        return id.getUser();
    }

    public void setUser(User user){
        id.setUser(user);
    }

    public Course getCourse(){
        return id.getCourse();
    }

    public void setCourse(Course course){
        id.setCourse(course);
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CourseProgress that = (CourseProgress) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
