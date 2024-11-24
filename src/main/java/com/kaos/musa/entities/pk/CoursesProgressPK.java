package com.kaos.musa.entities.pk;

import com.kaos.musa.entities.Course;
import com.kaos.musa.entities.Trail;
import com.kaos.musa.entities.User;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CoursesProgressPK implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "trail_id")
    private Trail trail;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Trail getTrail() {
        return trail;
    }

    public void setTrail(Trail trail) {
        this.trail = trail;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CoursesProgressPK that = (CoursesProgressPK) o;
        return Objects.equals(getUser(), that.getUser()) && Objects.equals(getCourse(), that.getCourse()) && Objects.equals(getTrail(), that.getTrail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser(), getCourse(), getTrail());
    }
}