package practice2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    static void main() {
        System.out.println(Arrays.toString(bucketSort(new double[] {0.1, 0.15, 0.99, 0.05, 0.8, 0.49, 0.2})));
    }

    static double[] bucketSort(double[] a) {
        List<List<Double>> buckets = new ArrayList<>(a.length);

        for (int i = 0; i < a.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int i = 0; i < a.length; i++) {
            buckets.get((int)(a[i] * a.length)).add(a[i]);
        }

        double[] result = new double[a.length];
        int index = 0;

        for (List<Double> bucket : buckets) {
            bubbleSort(bucket);
            for (double val : bucket) {
                result[index] = val;
                index++;
            }
        }
        return result;
    }

    static void bubbleSort(List<Double> a) {
        for (int i = 0; i < a.size() - 1; i++) {
            for (int j = 1; j < a.size(); j++) {
                if (a.get(i) > a.get(j)) {
                    double temp = a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, temp);
                }
            }
        }
    }
}
