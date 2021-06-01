package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Enter id: ");
        boolean rsl = tracker.delete(id);
        if (rsl) {
            out.println("=== Item deleted successfully ====");
        } else {
            out.println("=== Error ====");
        }
        return true;
    }
}
