/*
package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "ru.job4j.tracker.Item name", "1"}
        );
        Store memTracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findAll().get(0).getName(), is("ru.job4j.tracker.Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Store memTracker = new MemTracker();
 Добавим в tracker новую заявку

        Item item = memTracker.add(new Item("Replaced item"));
 Входные данные должны содержать ID добавленной заявки item.getId()

        String replacedName = "New item name";
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", item.getId(), replacedName, "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Store memTracker = new MemTracker();
 Добавим в tracker новую заявку

        Item item = memTracker.add(new Item("Deleted item"));
 Входные данные должны содержать ID добавленной заявки item.getId()

        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", item.getId(), "1"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(memTracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Store memTracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Exit Program ====" + System.lineSeparator() +
                        "Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAll() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1", "6"}
        );
        Store memTracker = new MemTracker();
        Item item = memTracker.add(new Item("Showed item"));
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ShowAllAction(out));
        actions.add(new ReplaceAction(out));
        actions.add(new DeleteAction(out));
        actions.add(new FindByIdAction(out));
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Create a new ru.job4j.tracker.Item ====" + System.lineSeparator() +
                        "1. === Show all items ====" + System.lineSeparator() +
                        "2. === Edit item ====" + System.lineSeparator() +
                        "3. === Delete item ====" + System.lineSeparator() +
                        "4. === Find item by Id ====" + System.lineSeparator() +
                        "5. === Find item by name ====" + System.lineSeparator() +
                        "6. === Exit Program ====" + System.lineSeparator() +
                        "0. Name: Showed item id: " + item.getId() + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Create a new ru.job4j.tracker.Item ====" + System.lineSeparator() +
                        "1. === Show all items ====" + System.lineSeparator() +
                        "2. === Edit item ====" + System.lineSeparator() +
                        "3. === Delete item ====" + System.lineSeparator() +
                        "4. === Find item by Id ====" + System.lineSeparator() +
                        "5. === Find item by name ====" + System.lineSeparator() +
                        "6. === Exit Program ====" + System.lineSeparator() +
                        "Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Store memTracker = new MemTracker();
 Добавим в tracker новую заявку

        Item item = memTracker.add(new Item("Found by name item"));
 Входные данные должны содержать Name добавленной заявки

        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"5", item.getName(), "6"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ShowAllAction(out));
        actions.add(new ReplaceAction(out));
        actions.add(new DeleteAction(out));
        actions.add(new FindByIdAction(out));
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Create a new ru.job4j.tracker.Item ====" + System.lineSeparator() +
                        "1. === Show all items ====" + System.lineSeparator() +
                        "2. === Edit item ====" + System.lineSeparator() +
                        "3. === Delete item ====" + System.lineSeparator() +
                        "4. === Find item by Id ====" + System.lineSeparator() +
                        "5. === Find item by name ====" + System.lineSeparator() +
                        "6. === Exit Program ====" + System.lineSeparator() +
                        "Name: Found by name item id: " + item.getId() + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Create a new ru.job4j.tracker.Item ====" + System.lineSeparator() +
                        "1. === Show all items ====" + System.lineSeparator() +
                        "2. === Edit item ====" + System.lineSeparator() +
                        "3. === Delete item ====" + System.lineSeparator() +
                        "4. === Find item by Id ====" + System.lineSeparator() +
                        "5. === Find item by name ====" + System.lineSeparator() +
                        "6. === Exit Program ====" + System.lineSeparator() +
                        "Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Store memTracker = new MemTracker();
 Добавим в tracker новую заявку

        Item item = memTracker.add(new Item("Found by ID item"));
 Входные данные должны содержать ID добавленной заявки

        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"4", item.getId(), "6"}
        );
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ShowAllAction(out));
        actions.add(new ReplaceAction(out));
        actions.add(new DeleteAction(out));
        actions.add(new FindByIdAction(out));
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Create a new ru.job4j.tracker.Item ====" + System.lineSeparator() +
                        "1. === Show all items ====" + System.lineSeparator() +
                        "2. === Edit item ====" + System.lineSeparator() +
                        "3. === Delete item ====" + System.lineSeparator() +
                        "4. === Find item by Id ====" + System.lineSeparator() +
                        "5. === Find item by name ====" + System.lineSeparator() +
                        "6. === Exit Program ====" + System.lineSeparator() +
                        "Found by ID item" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Create a new ru.job4j.tracker.Item ====" + System.lineSeparator() +
                        "1. === Show all items ====" + System.lineSeparator() +
                        "2. === Edit item ====" + System.lineSeparator() +
                        "3. === Delete item ====" + System.lineSeparator() +
                        "4. === Find item by Id ====" + System.lineSeparator() +
                        "5. === Find item by name ====" + System.lineSeparator() +
                        "6. === Exit Program ====" + System.lineSeparator() +
                        "Exit Program" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"2", "0"}
        );
        Store memTracker = new MemTracker();
        ArrayList<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction(out));
        new StartUI(out).init(in, memTracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. === Exit Program ====%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. === Exit Program ====%n"
                                + "Exit Program%n"
                )
        ));
    }
}
*/
