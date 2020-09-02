import java.util.Comparator;

public class ItemSortByNameDesc implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o2.getName().compareTo(o1.getName());
    }
}

