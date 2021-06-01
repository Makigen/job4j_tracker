package ru.job4j.tracker;

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
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (!item.equals(null)) {
            String name = input.askStr("Enter new name: ");
            item.setName(name);
            tracker.replace(id, item);
            out.println("=== Replace successful ====");
        } else {
            out.println("=== Error ====");
        }
        return true;
    }
}
