package ex;

import org.junit.Test;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenLessThan0() {
        Fact.calc(-1);
    }
}

