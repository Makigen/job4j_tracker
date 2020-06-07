public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item [] allFound = tracker.findByName(name);
        if (allFound != null) {
            for (int i = 0; i < allFound.length; i++) {
                System.out.println("Name: " + allFound[i].getName() + " id: " + allFound[i].getId());
            }
        } else {
            System.out.println("=== Error ====");
        }
        return true;
    }
}
