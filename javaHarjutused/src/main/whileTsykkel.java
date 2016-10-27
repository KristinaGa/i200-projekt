package main;

/**
 * Created by Kristina on 25.10.16.
 */
public class whileTsykkel {
    public static void main(String[] args) {
        int[] kiirused = {87, 91, 95, 86, 89};

        int l = 0;
        while (l < 5) {
            if (kiirused[l] > 90) {
                System.out.println("Trahv");
            }
            l = l + 1;


        }
        System.out.println("Tsükkel läbi");
    }
}
