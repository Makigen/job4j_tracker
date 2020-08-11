public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allFound = tracker.findAll();
        for (int i = 0; i < allFound.length; i++) {
            out.println(i + ". Name: " + allFound[i].getName() + " id: " + allFound[i].getId());
        }
        return true;
    }
}
