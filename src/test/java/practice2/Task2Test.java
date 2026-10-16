package practice2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static practice2.Task2.radixSort;

class Task2Test {
    @Test
    public void testRadixSort() {
        assertArrayEquals(
                new int[]{7, 100000001, 900000000},
                radixSort(new int[]{100000001, 7, 900000000}
                ));
    }
}