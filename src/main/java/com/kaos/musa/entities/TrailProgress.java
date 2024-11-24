package com.kaos.musa.entities;

import com.kaos.musa.entities.pk.TrailProgressPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "trail_progress")
public class TrailProgress implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private TrailProgressPK id = new TrailProgressPK();

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "trail_completion")
    private Double completion;

    public TrailProgress() {
    }

    public TrailProgress(Trail trail, User user, LocalDateTime startDate, Double completion) {
        id.setTrail(trail);
        id.setUser(user);
        this.startDate = startDate;
        this.completion = completion;
    }

    public Trail getTrail(){
        return id.getTrail();
    }

    public void setTrail(Trail trail){
        id.setTrail(trail);
    }


    public User getUser(){
       return id.getUser();
    }

    public void setUser(User user){
        id.setUser(user);
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
        TrailProgress that = (TrailProgress) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
