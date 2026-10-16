package practice2;

import java.util.Arrays;

public class Task2 {
    static void main() {
        System.out.println(Arrays.toString(radixSort(new int[] {12562, 2461, 154, 42, 567})));
    }

    static int[] radixSort(int[] a) {
        int max = 0;
        for (int val : a) {
            max = Math.max(val, max);
        }

        for (int place = 1; (max / place) > 0; place *= 10) {
            countingSortByDigit(a, place);
            System.out.println(Arrays.toString(a));

        }
        return a;
    }

    static void countingSortByDigit(int[] a, int place) {
        int[] count = new int[10];
        for (int val : a) {
            count[(val / place) % 10] += 1;
        }
        for (int d = 1; d < count.length; d++) {
            count[d] += count[d-1];
        }
        int[] result = new int[a.length];
//        for (int i = a.length - 1; i >= 0; i--) {
        for (int i = 0; i < a.length; i++) {
            int digit = (a[i] / place) % 10;
            result[--count[digit]] = a[i];
        }
        System.arraycopy(result, 0, a, 0, a.length);
    }


}
