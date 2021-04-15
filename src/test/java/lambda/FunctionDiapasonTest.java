package lambda;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class FunctionDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionDiapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertEquals(result, expected);
    }

    @Test
    public void whenSquareFunction() {
        List<Double> result = FunctionDiapason.diapason(5, 8, x -> x * x);
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertEquals(result, expected);
    }

    @Test
    public void whenExponentialFunction() {
        List<Double> result = FunctionDiapason.diapason(2, 5, x -> Math.pow(2D, x));
        List<Double> expected = Arrays.asList(4D, 8D, 16D);
           assertEquals(result, expected);
    }
}
