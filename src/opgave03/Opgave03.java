package opgave03;

import opgave03.models.ArrayListRing;
import opgave03.models.Ring;

import java.util.ArrayList;
import java.util.Arrays;

public class Opgave03 {
    public static void main(String[] args) {
        Integer n1 = 1;
        Integer n2 = 2;
        Integer n3 = 3;
        Integer n4 = 4;

        ArrayListRing<Integer> arrayListRing = new ArrayListRing<Integer>();
        arrayListRing.add(n1);
        arrayListRing.add(n2);
        arrayListRing.add(n3);
        arrayListRing.add(n4);

        System.out.println("Current item: expects \"4\" = " + arrayListRing.getCurrentItem());
        arrayListRing.advance();
        System.out.println("Current item: expects \"1\" = " + arrayListRing.getCurrentItem());
        arrayListRing.removeCurrentItem();
        System.out.println("Current item: expects \"2\" = " + arrayListRing.getCurrentItem());
        arrayListRing.removeItem(2);
        System.out.println("Current item: expects \"3\" = " + arrayListRing.getCurrentItem());
        arrayListRing.add(n1);
        System.out.println("Current item: expects \"1\" = " + arrayListRing.getCurrentItem());
        System.out.println(arrayListRing.debugGetArrayList());
        arrayListRing.map(i->i*2);
        System.out.println(arrayListRing.debugGetArrayList());
        System.out.println(arrayListRing.getCurrentItem());

        ArrayListRing<Integer> newRing = (ArrayListRing<Integer>) arrayListRing.where(i -> i > 6);
        System.out.println(newRing.debugGetArrayList());

    }

}
