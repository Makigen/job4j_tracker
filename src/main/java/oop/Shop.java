package oop;

public class Shop {
    public Product[] delete(Product[] products, int index) {
        if (products[index] != null) {
            products[index] = null;
        }
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                int j = i;
                while (j++ < products.length - 1) {
                    if (products[j] != null) {
                        products[i] = products[j];
                        products[j] = null;
                        break;
                    }
                }
            }
        }
        return products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println(products[i]);
            }
        }
        System.out.println();
        Shop shop = new Shop();
        shop.delete(products, 1);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println(products[i]);
            }
        }
        System.out.println();
        shop.delete(products, 0);
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println(products[i]);
            }
        }
    }
}

