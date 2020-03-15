package oop;

import java.util.Date;

public class Student {
    private String name;
    private String group;
    private Date entrance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getEntrance() {
        return entrance;
    }

    public void setEntrance(Date entrance) {
        this.entrance = entrance;
    }

    public void music(String lyrics) {
        System.out.println("I can sign a song : " + lyrics);
    }

    public void song() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        String song = "I believe, I can fly";
        petya.music(song);
    }
}