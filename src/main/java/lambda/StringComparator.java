package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringComparator {

    Comparator<String> cmpText = (left, right) -> left.compareTo(right);
    
    Comparator<String> cmpDescSize = (left, right) -> right.length() - left.length();

    public static void main(String[] args) {
        String s1 = "Kirill";
        String s2 = "Malikov";
        List<String> names = Arrays.asList(s1, s2);
        StringComparator stc = new StringComparator();
        names.sort(stc.cmpText);
        System.out.println(names);
        names.sort(stc.cmpDescSize);
        System.out.println(names);
    }
}
