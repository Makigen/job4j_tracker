package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamInteger {

    public static void main(String[] args) {
        int start = -15;
        int end = 15;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        List<Integer> positive = list.stream().filter(Integer -> Integer > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
