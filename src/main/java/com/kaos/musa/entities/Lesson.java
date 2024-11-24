package com.kaos.musa.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "lessons")
public class Lesson implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lesson_id", nullable = false)
    private Integer id;

    @Column(name = "lesson_name", nullable = false)
    private String name;

    @Column(name = "lesson_desc", nullable = false)
    private String desc;

    @Column(name = "lesson_link", nullable = false)
    private String lessonVideo;

    @ManyToOne(cascade = CascadeType.   ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    public Lesson() {
    }

    public Lesson(Integer id, String name, String desc, String lessonVideo) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.lessonVideo = lessonVideo;
    }


    public Lesson(Integer id, String name, String desc, String lessonVideo, Course course) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.lessonVideo = lessonVideo;
        this.course = course;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLessonVideo() {
        return lessonVideo;
    }

    public void setLessonVideo(String lessonVideo) {
        this.lessonVideo = lessonVideo;
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
        Lesson lesson = (Lesson) o;
        return Objects.equals(getId(), lesson.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
