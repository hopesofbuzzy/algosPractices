package practice2;

import java.util.Arrays;

public class Task1 {
    static void main() {
        System.out.println(Arrays.toString(countingSort(new int[] {2, 3, 1, 0, 1, 2})));
    }

    static int[] countingSort(int[] a) {
        int[] count = new int[4];
        for (int i = 0; i < a.length; i++) {
            count[a[i]] += 1;
        }
        int[] result = new int[a.length];

        int index = 0;
        for (int num = 0; num < count.length; num++) {
            for (int repeat = 0; repeat < count[num]; repeat++) {
                result[index++] = num;
            }
        }
        return result;
    }
}
