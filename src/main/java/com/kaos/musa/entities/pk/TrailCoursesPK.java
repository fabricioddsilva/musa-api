package com.kaos.musa.entities.pk;

import com.kaos.musa.entities.Course;
import com.kaos.musa.entities.Trail;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TrailCoursesPK implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "trail_id")
    private Trail trail;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Trail getTrail() {
        return trail;
    }

    public void setTrail(Trail trail) {
        this.trail = trail;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TrailCoursesPK that = (TrailCoursesPK) o;
        return Objects.equals(getTrail(), that.getTrail()) && Objects.equals(getCourse(), that.getCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTrail(), getCourse());
    }
}
