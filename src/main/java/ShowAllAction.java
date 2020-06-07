public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] allFound = tracker.findAll();
        for (int i = 0; i < allFound.length; i++) {
            System.out.println(i + ". Name: " + allFound[i].getName() + " id: " + allFound[i].getId());
        }
        return true;
    }
}
