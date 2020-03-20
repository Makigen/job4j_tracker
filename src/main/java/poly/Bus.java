package poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Attention, the doors are closing.");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Number of passengers: " + passengers);
    }

    @Override
    public double fuel(double fuel) {
        double total = 0;
        double price = 1.80;
        price = fuel * price;
        return total;
    }
}
