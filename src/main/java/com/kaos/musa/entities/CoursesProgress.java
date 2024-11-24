package com.kaos.musa.entities;

import com.kaos.musa.entities.pk.CoursesProgressPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "courses_in_progress")
public class CoursesProgress implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CoursesProgressPK id = new CoursesProgressPK();

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "course_completion")
    private Double completion;

    public CoursesProgress() {
    }

    public CoursesProgress(CoursesProgressPK id, LocalDateTime startDate, LocalDateTime endDate, Double completion) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.completion = completion;
    }

    public CoursesProgressPK getId() {
        return id;
    }

    public void setId(CoursesProgressPK id) {
        this.id = id;
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

    public Double getCompletion() {
        return completion;
    }

    public void setCompletion(Double completion) {
        this.completion = completion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CoursesProgress that = (CoursesProgress) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
