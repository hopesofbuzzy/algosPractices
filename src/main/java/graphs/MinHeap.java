package graphs;

public class MinHeap {
    private HeapEntry[] data = new HeapEntry[16];
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int vertex, long distance) {
        ensureCapacity();
        // sift up
        int index = size++;
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (data[parent].distance() <= distance) {
                break;
            }
            data[index] = data[parent];
            index = parent;
        }
        data[index] = new HeapEntry(vertex, distance);
    }

    private void ensureCapacity() {
        if (size < data.length) return;
        HeapEntry[] newData = new HeapEntry[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
    }

    public HeapEntry removeMin() {
        // todo check empty
        if (isEmpty()) {
            throw new IllegalStateException("Пустая куча!");
        }
        HeapEntry result = data[0];
        HeapEntry last = data[--size];
        if (size == 0) return result;

        data[0] = last;
        int index = 0;

        // sift down
        while (true) {
            int left = 2 * index + 1;
            if (left >= size) break;
            int right = 2 * index + 2;
            int child = left;
            if ((right < size) &&
                data[right].distance() < data[left].distance()) {
                child = right;
            }

            if (data[index].distance() <= data[child].distance()) break;
            HeapEntry temp = data[index];
            data[index] = data[child];
            data[child] = temp;
        }
        return result;
    }
}
