package oop;

public class Tiger extends Predator{

    public Tiger() {
        super();
        System.out.println("Tiger");
    }

    public Tiger(String name) {
        super(name);
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        Tiger tigra = new Tiger("Tigra");
        System.out.println(tigra.name);
    }
}
