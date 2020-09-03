package collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        return Integer.parseInt(left.replaceAll("[^0-9]", "")) - Integer.parseInt(right.replaceAll("[^0-9]", ""));
    }
}