package main;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Kristina on 27.10.16.
 */
public class Massiivid {
    public static void main(String[] args) {
        int[] a = {1, 5, 3, 6};
        String[] b = {"Tere", "uus", "maailm"};

        System.out.println(Arrays.toString(a)); //kasutan Arrays klassi toString meetodit

        ArrayList c = new ArrayList();
        c.add(5);
        c.add(7);
        c.add(1);
        c.add("string");

        System.out.println(c.get(3)); //prindib välja arraylistist 3 kohal oleva väärtuse

        System.out.println(c.contains("string")); //prindib välja true või false - kas arraylistis on selline väärtus
    }
}
