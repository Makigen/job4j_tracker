public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item newItem = new Item(name);
        boolean rsl = tracker.replace(id, newItem);
        if (rsl) {
            System.out.println("=== Replace successful ====");
        } else {
            System.out.println("=== Error ====");
        }
        return true;
    }
}
