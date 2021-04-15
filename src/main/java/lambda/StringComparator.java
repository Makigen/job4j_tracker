package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringComparator {
    public static void main(String[] args) {
        Comparator<String> cmpText = (left, right) -> left.compareTo(right);
        Comparator<String> cmpDescSize = (left, right) -> Integer.compare(right.length(), left.length());
        String s1 = "Kirill";
        String s2 = "Malikov";
        List<String> names = Arrays.asList(s1, s2);
        names.sort(cmpText);
        System.out.println(names);
        names.sort(cmpDescSize);
        System.out.println(names);
    }
}
