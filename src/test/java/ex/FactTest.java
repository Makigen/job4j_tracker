package ex;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenLessThan0() {
        Fact.calc(-1);
    }

    @Test
    public void when3Than6() {
        assertThat(Fact.calc(5), is(120));
    }
}

