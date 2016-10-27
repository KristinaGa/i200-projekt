package main;

/**
 * Created by Kristina on 25.10.16.
 */
public class Muutujad {
    public static void main(String[] args) {
        int minuRaha = 150;
        int ostukorv = 100;


        minuRaha = minuRaha - ostukorv;
        System.out.println(minuRaha);

        String minuRahaEurodes = minuRaha + "€";
        System.out.println(minuRahaEurodes);
    }
}
