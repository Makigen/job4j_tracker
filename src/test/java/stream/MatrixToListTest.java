package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MatrixToListTest {

    @Test
    public void doubleArrayOfIntegersToList() {
        Integer[][] integers = {{1, 2, 3}, {0, 9, 8, 7}};
        List<Integer> rsl = MatrixToList.matrixToList(integers);
        List<Integer> expected = Arrays.asList(1, 2, 3, 0, 9, 8, 7);
        assertEquals(rsl, expected);
    }
}
