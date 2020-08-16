import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", item.getId(), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", item.getId(), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
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
                new String[] {"1", "6"}
        );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Showed item"));
        UserAction[] actions = {
                new CreateAction(out),
                new ShowAllAction(out),
                new ReplaceAction(out),
                new DeleteAction(out),
                new FindByIdAction(out),
                new FindByNameAction(out),
                new ExitAction(out),
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                "0. === Create a new Item ====" + System.lineSeparator() +
                "1. === Show all items ====" + System.lineSeparator() +
                "2. === Edit item ====" + System.lineSeparator() +
                "3. === Delete item ====" + System.lineSeparator() +
                "4. === Find item by Id ====" + System.lineSeparator() +
                "5. === Find item by name ====" + System.lineSeparator() +
                 "6. === Exit Program ====" + System.lineSeparator() +
                 "0. Name: Showed item id: " + item.getId() + System.lineSeparator() +
                 "Menu." + System.lineSeparator() +
                 "0. === Create a new Item ====" + System.lineSeparator() +
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
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Found by name item"));
        /* Входные данные должны содержать Name добавленной заявки */
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"5", item.getName(), "6"}
        );
        UserAction[] actions = {
                new CreateAction(out),
                new ShowAllAction(out),
                new ReplaceAction(out),
                new DeleteAction(out),
                new FindByIdAction(out),
                new FindByNameAction(out),
                new ExitAction(out),
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Create a new Item ====" + System.lineSeparator() +
                        "1. === Show all items ====" + System.lineSeparator() +
                        "2. === Edit item ====" + System.lineSeparator() +
                        "3. === Delete item ====" + System.lineSeparator() +
                        "4. === Find item by Id ====" + System.lineSeparator() +
                        "5. === Find item by name ====" + System.lineSeparator() +
                        "6. === Exit Program ====" + System.lineSeparator() +
                        "Name: Found by name item id: " + item.getId() + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Create a new Item ====" + System.lineSeparator() +
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
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Found by ID item"));
        /* Входные данные должны содержать ID добавленной заявки */
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"4", item.getId(), "6"}
        );
        UserAction[] actions = {
                new CreateAction(out),
                new ShowAllAction(out),
                new ReplaceAction(out),
                new DeleteAction(out),
                new FindByIdAction(out),
                new FindByNameAction(out),
                new ExitAction(out),
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Create a new Item ====" + System.lineSeparator() +
                        "1. === Show all items ====" + System.lineSeparator() +
                        "2. === Edit item ====" + System.lineSeparator() +
                        "3. === Delete item ====" + System.lineSeparator() +
                        "4. === Find item by Id ====" + System.lineSeparator() +
                        "5. === Find item by name ====" + System.lineSeparator() +
                        "6. === Exit Program ====" + System.lineSeparator() +
                        "Found by ID item" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Create a new Item ====" + System.lineSeparator() +
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
                new String[] {"2", "0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
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