package com.kaos.musa.entities;

import com.kaos.musa.entities.pk.TrailCoursesPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "trail_courses")
public class TrailCourses implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private TrailCoursesPK id = new TrailCoursesPK();

    public TrailCourses() {
    }

    public TrailCourses(Trail trail, Course course){
        id.setTrail(trail);
        id.setCourse(course);
    }

    public Trail getTrail(){
        return id.getTrail();
    }

    public void setTrail(Trail trail){
        id.setTrail(trail);
    }

    public Course getCourse(){
        return id.getCourse();
    }

    public void setCourse(Course course){
        id.setCourse(course);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TrailCourses that = (TrailCourses) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
