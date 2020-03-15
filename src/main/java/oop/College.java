package oop;

import java.util.Date;

public class College {
    public static void main(String[] args) {
    Student student = new Student();
    student.setName("Kirill Malikov");
    student.setGroup("SF-3");
    student.setEntrance(new Date());

    System.out.println(student.getName() + " enterd group " + student.getGroup() + " : " + student.getEntrance());
    }
}

