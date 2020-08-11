public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        Item found = tracker.findById(id);
        if (found != null) {
            String name = input.askStr("Enter new name: ");
            Item newItem = new Item(name);
            tracker.replace(id, newItem);
            out.println("=== Replace successful ====");
        } else {
            out.println("=== Error ====");
        }
        return true;
    }
}
