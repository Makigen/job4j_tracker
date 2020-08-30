import java.util.List;

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
        List<Item> allFound = tracker.findByName(name);
        if (allFound.size() > 0) {
            for (Item item : allFound) {
                out.println("Name: " + item.getName() + " id: " + item.getId());
            }
        } else {
            out.println("=== Error ====");
        }
        return true;
    }
}
