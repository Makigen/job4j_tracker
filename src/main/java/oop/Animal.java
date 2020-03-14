package oop;

public class Animal {
    String name;

    public Animal() {
        super();
        System.out.println("Animal");
    }

    public Animal(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal tiger = new Animal("Shere Khan");
        System.out.println(tiger.name);
    }
}
