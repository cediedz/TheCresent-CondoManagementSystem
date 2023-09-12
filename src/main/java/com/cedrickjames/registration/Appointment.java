package com.cedrickjames.registration;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    private int id;
    private String name;
    private LocalDate date;
    private LocalTime time;

    public Appointment(int id, String name, LocalDate date, LocalTime time) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Appointment [id=" + id + ", name=" + name + ", date=" + date + ", time=" + time + "]";
    }
}
