public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        Item found = tracker.findById(id);
        if (found != null) {
            out.println(found.getName());
        } else {
            out.println("=== Error ====");
        }
        return true;
    }
}
