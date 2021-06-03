package ru.job4j.tracker;

import java.util.List;

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
    public boolean execute(Input input, Store tracker) {
        List<Item> allFound = tracker.findAll();
        for (Item item : allFound) {
            out.println(allFound.indexOf(item) + ". Name: " + item.getName() + " id: " + item.getId());
        }
        return true;
    }
}
