package com.mariia.habittracker.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Project name is required")
    private String name;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate day;
    private boolean done;
    private Integer value;

    private Habit(String name, LocalDate day, boolean done, Integer value) {
        this.name = name;
        if (day == null) {
            this.day = LocalDate.now();
        } else {
            this.day = day;
        }
        this.done = done;
        this.value = value;
    }

    public Habit() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habit habit = (Habit) o;
        return done == habit.done && Objects.equals(id, habit.id) && Objects.equals(name, habit.name) && Objects.equals(day, habit.day) && Objects.equals(value, habit.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, day, done, value);
    }

    @Override
    public String toString() {
        return "Habit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", day=" + day +
                ", done=" + done +
                ", value=" + value +
                '}';
    }
}
