import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemSortByNameDescTest {
    @Test
    public void compare1() {
        List<Item> items = new ArrayList<>(List.of(new Item("C"), new Item("A"), new Item("B")));
        items.sort(new ItemSortByNameDesc());
        assertThat(new String[]{items.get(0).getName(), items.get(1).getName(), items.get(2).getName()}, is(new String[]{"C", "B", "A"}));
    }

    @Test
    public void compare2() {
        List<Item> items = new ArrayList<>(List.of(new Item("3"), new Item("1"), new Item("2")));
        items.sort(new ItemSortByNameDesc());
        assertThat(new String[]{items.get(0).getName(), items.get(1).getName(), items.get(2).getName()}, is(new String[]{"3", "2", "1"}));
    }
}
