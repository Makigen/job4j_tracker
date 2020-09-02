import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemSortByNameAscTest {
    @Test
    public void compare() {
        List<Item> items = new ArrayList<>(List.of(new Item("C"), new Item("A"), new Item("B")));
        items.sort(new ItemSortByNameAsc());
        assertThat(new String[]{items.get(0).getName(), items.get(1).getName(), items.get(2).getName()}, is(new String[]{"A", "B", "C"}));
    }
}
