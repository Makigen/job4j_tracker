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
        Item item = new Item(id);
        if (tracker.replace(id, item)) {
            String name = input.askStr("Enter new name: ");
            item.setName(name);
            out.println("=== Replace successful ====");
        } else {
            out.println("=== Error ====");
        }
        return true;
    }
}
