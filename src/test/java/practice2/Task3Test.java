package practice2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static practice2.Task3.bucketSort;

class Task3Test {
    @Test
    public void testRadixSort() {
        assertArrayEquals(
                new double[]{0.05, 0.1, 0.2, 0.49, 0.99},
                bucketSort(new double[]{0.2, 0.99, 0.1, 0.05, 0.49}
                ));
    }
}