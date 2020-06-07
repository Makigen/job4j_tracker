public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        boolean rsl = tracker.delete(id);
        if (rsl) {
            System.out.println("=== Item deleted successfully ====");
        } else {
            System.out.println("=== Error ====");
        }
        return true;
    }
}
