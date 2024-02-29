package opgave03.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListRingTest {

    ArrayListRing<Integer> arrayListRing;

    @BeforeEach
    void setUp() {
        Integer n1 = 1;
        Integer n2 = 2;
        Integer n3 = 3;
        Integer n4 = 4;

        arrayListRing = new ArrayListRing<Integer>();
        arrayListRing.add(n1);
        arrayListRing.add(n2);
        arrayListRing.add(n3);
        arrayListRing.add(n4);
    }

    @Test
    void advance() {
        arrayListRing.advance();
        int actual = arrayListRing.getCurrentItem();
        int expected = 1;

        assertEquals(expected,actual);
    }

    @Test
    void getCurrentItem() {
        int actual = arrayListRing.getCurrentItem();
        int expected = 4;

        assertEquals(expected,actual);
    }

    @Test
    void add() {
        int toAdd = 5;
        arrayListRing.add(toAdd);
        int actual = arrayListRing.getCurrentItem();
        int expected = toAdd;

        assertEquals(expected,actual);
    }

    @Test
    void removeItem() {
        arrayListRing.removeItem(2);
        ArrayList<Integer> actual = arrayListRing.debugGetArrayList();
        ArrayList<Integer> expected = new ArrayList<>(List.of(1,3,4));

        assertEquals(expected,actual);
    }

    @Test
    void removeCurrentItem() {
        arrayListRing.removeCurrentItem();
        int actual = arrayListRing.getCurrentItem();
        int expected = 1;

        assertEquals(expected,actual);
    }

    @Test
    void map() {
        arrayListRing.map(i -> i * 2);
        ArrayList<Integer> actual = arrayListRing.debugGetArrayList();
        ArrayList<Integer> expected = new ArrayList<>(List.of(2,4,6,8));

        assertEquals(expected,actual);
    }

    @Test
    void where() {
        ArrayListRing<Integer> actual = arrayListRing.where(i -> i > 2);
        ArrayListRing<Integer> expected = new ArrayListRing<>();
        expected.add(3);
        expected.add(4);

        assertEquals(expected.size(),actual.size());

        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.debugGet(i),actual.debugGet(i));
        }

    }
}