package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {

    public static List<Integer> matrixToList(Integer[][] integers) {
        return Stream.of(integers).flatMap(arr -> Stream.of(arr)).collect(Collectors.toList());
    }
}
