package ru.collection;

import java.util.Comparator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    void whenComparatorAscByName() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 0));
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenComparatorDescByName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 3),
                new Job("Fix bug", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenComparatorAscByPriority() {
        Comparator<Job> cmpPriority = new JobAscByPriority();
        int rsl = cmpPriority.compare(
                new Job("Wash Car", 5),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenComparatorDescByPriority() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int rsl = cmpPriority.compare(
                new Job("Wash car", 3),
                new Job("Fix bug", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenComparatorDescByNameLength() {
        Comparator<Job> cmpNameLength = new JobDescByNameLength();
        int rsl = cmpNameLength.compare(
                new Job("Wash car", 3),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenComparatorByNameAndNameLength() {
        Comparator<Job> cmpNameLength = new JobAscByName().thenComparing(new JobDescByName());
        int rsl = cmpNameLength.compare(
                new Job("Fix Bug", 3),
                new Job("Wash car", 5)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    void whenComparatorAscByNameAndAscPriority() {
        Comparator<Job> cmpNamePriorityAsc = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriorityAsc.compare(
                new Job("Wash Car", 1),
                new Job("Wake Up", 5)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    void whenComparatorAscByNameThenDescByNameLengthAndAscPriority() {
        Comparator<Job> cmpAscNameLengthPriority = new JobAscByName()
                .thenComparing(new JobDescByNameLength())
                .thenComparing(new JobAscByPriority());
        int rsl = cmpAscNameLengthPriority.compare(
                new Job("Wash Car", 5),
                new Job("Impl task", 3)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}
