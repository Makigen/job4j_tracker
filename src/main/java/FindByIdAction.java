public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        Item found = tracker.findById(id);
        if (found != null) {
            System.out.println(found.getName());
        } else {
            System.out.println("=== Error ====");
        }
        return true;
    }
}
