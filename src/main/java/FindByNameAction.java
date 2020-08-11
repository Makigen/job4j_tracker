public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item [] allFound = tracker.findByName(name);
        if (allFound.length > 0) {
            for (int i = 0; i < allFound.length; i++) {
                out.println("Name: " + allFound[i].getName() + " id: " + allFound[i].getId());
            }
        } else {
            out.println("=== Error ====");
        }
        return true;
    }
}
