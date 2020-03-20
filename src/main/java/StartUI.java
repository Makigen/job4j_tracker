import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                for (int i = 0; i < tracker.findAll().length && tracker.findAll().length > 0; i++) {
                    System.out.println(i + ". Name: " + tracker.findAll()[i].getName() + " id: " + tracker.findAll()[i].getId());
                }
            }
            else if (select == 2) {
                System.out.println("=== Edit item ====");
                System.out.print("Enter id: ");
                String id = scanner.nextLine();
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item newItem = new Item(name);
                boolean rsl = tracker.replace(id, newItem);
                if (rsl) {
                    System.out.println("=== Replace successful ====");
                } else {
                    System.out.println("=== Error ====");
                }
            }
            else if (select == 3) {
                System.out.println("=== Delete item ====");
                System.out.print("Enter id: ");
                String id = scanner.nextLine();
                boolean rsl = tracker.delete(id);
                if (rsl) {
                    System.out.println("=== Item deleted successfully ====");
                } else {
                    System.out.println("=== Error ====");
                }
            }
            else if (select == 4) {
                System.out.println("=== Find item by Id ====");
                System.out.print("Enter id: ");
                String id = scanner.nextLine();
                System.out.println(tracker.findById(id).getName());
            }
            else if (select == 5) {
                System.out.println("=== Find item by name ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                tracker.findByName(name);
                for (int i = 0; i < tracker.findByName(name).length && tracker.findByName(name).length > 0; i++) {
                    System.out.println("Name: " + tracker.findByName(name)[i].getName() + " id: " + tracker.findByName(name)[i].getId());
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu:");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select:");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}