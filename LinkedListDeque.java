public class LinkedListDeque<T> {
    private IntNode sentinel;
    private int size;
    private class IntNode {
        private T item;
        private IntNode prev;
        private IntNode next;
        private IntNode(T i, IntNode p, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    public LinkedListDeque() {
        size = 0;
        sentinel = new IntNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(T item) {
        size += 1;
        IntNode newNode = new IntNode(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
    }
    public void addLast(T item) {
        size += 1;
        IntNode newNode = new IntNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;

    }
    public boolean isEmpty() {
        if (sentinel.next.equals(sentinel)) {
            return true;
        }
        return false;
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        IntNode goPrint = sentinel.next;
        while (goPrint != sentinel) {
            System.out.println(goPrint.item + " ");
            goPrint = goPrint.next;
        }
        System.out.println();
    }
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            size -= 1;
            T itemFirst = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            return itemFirst;
        }
    }
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            size -= 1;
            T itemLast = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            return itemLast;
        }
    }
    public T get(int index) {
        if (index > size) {
            return null;
        }
        IntNode toGet = sentinel.next;
        for (int i = 0; i < index;  i += 1) {
            toGet = toGet.next;
        }
        return toGet.item;
    }
    private T getRecursiveHelper(IntNode toGet, int index) {
        if (index == 0) {
            return toGet.item;
        }
        toGet = toGet.next;
        return getRecursiveHelper(toGet, index - 1);
    }
    public T getRecursive(int index) {
        return getRecursiveHelper(sentinel.next, index);
    }
}
