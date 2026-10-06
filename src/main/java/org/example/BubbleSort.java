package org.example;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BubbleSort {
    static void main() {
        printArray(new int[] {1, 2, 3});
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] a) {
        // Массивы передаются по ссылке.
        // printArray(a);
        for (int end = a.length - 1; end > 0; end--) {
            // Конец массива уже будет отсортирован по возр.
            boolean swapped = false;
            for (int i = 0; i < end; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
            // printArray(a);
            if (!swapped) {
                return;
            }
        }
        // printArray(a);
    }
}
