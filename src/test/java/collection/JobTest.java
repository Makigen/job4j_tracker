package collection;

import org.junit.Test;
import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareByNameAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName();
        int rsl = cmpNamePriority.compare(
                new Job("A task", 2),
                new Job("B task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareByNameDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("A task", 2),
                new Job("B task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareByPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("A task", 2),
                new Job("B task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareByPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("A task", 2),
                new Job("B task", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareCombinedAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("B task", 2),
                new Job("B task", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareCombinedDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("B task", 2),
                new Job("B task", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}