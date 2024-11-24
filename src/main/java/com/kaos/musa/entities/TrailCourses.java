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
    private static final long seriaVersionUID = 1L;

    @EmbeddedId
    private TrailCoursesPK id = new TrailCoursesPK();

    public TrailCourses() {
    }

    public TrailCourses(TrailCoursesPK id) {
        this.id = id;
    }

    public TrailCoursesPK getId() {
        return id;
    }

    public void setId(TrailCoursesPK id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TrailCourses that = (TrailCourses) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
