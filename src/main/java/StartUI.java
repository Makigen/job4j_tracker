
public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAll(Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] allfound = tracker.findAll();
        for (int i = 0; i < allfound.length && allfound.length > 0; i++) {
            System.out.println(i + ". Name: " + allfound[i].getName() + " id: " + allfound[i].getId());
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ====");
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item newItem = new Item(name);
        boolean rsl = tracker.replace(id, newItem);
        if (rsl) {
            System.out.println("=== Replace successful ====");
        } else {
            System.out.println("=== Error ====");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ====");
        String id = input.askStr("Enter id: ");
        boolean rsl = tracker.delete(id);
        if (rsl) {
            System.out.println("=== Item deleted successfully ====");
        } else {
            System.out.println("=== Error ====");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ====");
        String id = input.askStr("Enter id: ");
        if (tracker.findById(id) != null) {
            System.out.println(tracker.findById(id).getName());
        } else {
            System.out.println("=== Error ====");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Find item by name ====");
        String name = input.askStr("Enter name: ");
        Item [] allfound = tracker.findByName(name);
        if (allfound != null) {
            for (int i = 0; i < allfound.length && allfound.length > 0; i++) {
                System.out.println("Name: " + allfound[i].getName() + " id: " + allfound[i].getId());
            }
        } else {
            System.out.println("=== Error ====");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAll(tracker);
            }
            else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            }
            else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            }
            else if (select == 4) {
                StartUI.findById(input, tracker);
            }
            else if (select == 5) {
                StartUI.findByName(input, tracker);
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
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}