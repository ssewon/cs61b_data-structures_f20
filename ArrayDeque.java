public class ArrayDeque<T> implements Deque<T> {
    private T[] item;
    private int front;
    private int back;
    private int size;
    private static int rFactor = 2;
    private static double usageFactor = 0.25;

    public ArrayDeque() {
        item = (T []) new Object[8];
        size = 0;
        front = 0;
        back = 1;
    }

    private void resize() {
        T[] temp = (T []) new Object[item.length * rFactor];
        for (int i = 0; i < size; i += 1) {
            temp[i + 1] = get(i);
        }
        front = 0;
        back = size + 1;
        item = temp;
    }

    private void resizeDown() {
        T[] temp = (T []) new Object[item.length / rFactor];
        int numberIndex = (front + 1 + item.length) % item.length;
        System.arraycopy(item, numberIndex, temp, 1, size);
        front = 0;
        back = size + 1;
        item = temp;
    }

    @Override
    public void addFirst(T x) {
        if (size == item.length) {
            resize();
        }
        item[front] = x;
        front = (front - 1 + item.length) % item.length;
        size += 1;
    }
    @Override
    public void addLast(T x) {
        if (size == item.length) {
            resize();
        }
        item[back] = x;
        back = (back + 1) % item.length;
        size += 1;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        for (int i = 0; i < size; i += 1) {
            System.out.println(get(i) + " ");
        }
        System.out.println();
    }
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T itemFirst = item[(front + 1) % item.length];
        item[(front + 1) % item.length] = null;
        front = (front + 1) % item.length;
        size -= 1;
        if ((((double) (size + 2) / (double) item.length) < usageFactor) && (item.length >= 16)) {
            resizeDown();
        }
        return itemFirst;
    }
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T itemLast = item[(back - 1 + item.length) % item.length];
        item[(back - 1 + item.length) % item.length] = null;
        back = (back - 1 + item.length) % item.length;
        size -= 1;
        if ((((double) (size + 2) / (double) item.length) < usageFactor) && (item.length >= 16)) {
            resizeDown();
        }
        return itemLast;
    }
    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        return item[(front + 1 + index) % item.length];
    }
}
