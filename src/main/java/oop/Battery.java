package oop;

public class Battery {
    private int load;

    public Battery(int level){
        this.load = level;
    }

    public void exchange(Battery another) {
        another.load = another.load + this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery first = new Battery(78);
        Battery second = new Battery(22);
        System.out.println("first : " + first.load + ". second : " + second.load);
        first.exchange(second);
        System.out.println("first : " + first.load + ". second : " + second.load);
    }
}
