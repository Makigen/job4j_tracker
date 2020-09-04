package collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int index = 0; index < Math.min(left.length(), right.length()); index++) {
            char charLeft = left.charAt(index);
            char charRight = right.charAt(index);
            if (charLeft != charRight) {
                return Character.compare(charLeft, charRight);
            }
        }
        return left.length() - right.length();
    }
}
