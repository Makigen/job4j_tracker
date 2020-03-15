package oop;

import java.util.Date;

public class Police {
    public static void main(String[] args) {
        License license = new License();
        license.setOwner("Kirill Malikov");
        license.setModel("Volvo");
        license.setCode("MAK1GE");
        license.setCreated(new Date());

        System.out.println(license.getOwner() + " has a car - " + license.getModel() + " : " + license.getCode());
    }
}
