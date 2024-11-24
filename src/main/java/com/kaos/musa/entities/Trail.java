package com.kaos.musa.entities;

import com.kaos.musa.entities.enums.TrailLevel;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "trails")
public class Trail implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trail_id", nullable = false)
    private Integer id;

    @Column(name = "trail_name", nullable = false)
    private String name;

    @Column(name = "trail_level", nullable = false)
    @Enumerated(EnumType.STRING)
    private TrailLevel level;

    public Trail() {
    }

    public Trail(Integer id, String name, TrailLevel level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TrailLevel getLevel() {
        return level;
    }

    public void setLevel(TrailLevel level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Trail trail = (Trail) o;
        return Objects.equals(getId(), trail.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
