package practice2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static practice2.Task1.countingSort;

class Task1Test {
    @Test
    public void testCountingSort() {
        assertArrayEquals(new int[]{0, 0, 1, 1, 2}, countingSort(new int[]{1, 2, 1, 0, 0}));
        assertArrayEquals(new int[]{0, 1, 2, 2, 3}, countingSort(new int[]{2, 3, 1, 2, 0}));
    }
}