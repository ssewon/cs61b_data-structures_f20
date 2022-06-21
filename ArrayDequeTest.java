import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest{
    @Test
    public void test1() {
        ArrayDeque<Integer> x = new ArrayDeque<>();
        x.addFirst(0);
        x.addFirst(1);
        x.addLast(2);
        assertTrue(1 == x.get(0));
        x.addLast(4);
        x.addLast(5);
        x.addLast(6);
        assertTrue(5 == x.get(4));
        assertTrue(0 == x.get(1));
        x.addLast(9);
        assertTrue(1 == x.removeFirst());
        x.addLast(11);
        x.addLast(12);
        x.addFirst(13);
        assertTrue(13 == x.removeFirst());
        assertTrue(6 == x.get(4));
        assertTrue(0 == x.removeFirst());
        assertTrue(2 == x.removeFirst());
        assertTrue(4 == x.removeFirst());
        assertTrue(11 == x.get(3));
        assertTrue(5 == x.removeFirst());
        assertTrue(9 == x.get(1));
        assertTrue(12 == x.removeLast());
        assertTrue(6 == x.removeFirst());
    }

}
