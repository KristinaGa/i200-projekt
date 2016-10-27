package main;

import java.util.Scanner;

/**
 * Created by Kristina on 25.10.16.
 */
public class TauriOpetab {
    public static void main(String[] args) {
        //teen muutuja sisend, mis loeb süsteemi sisestatavaid väärtusi (hetkel klaviatuurilt, aga võib olla ka nt
        // hiireklikk)
        Scanner sisend = new Scanner(System.in);

        //teen muutuja õige parooli jaoks
        String oigePassword = "kiisupall";

        //prindi välja "Sisesta password"
        System.out.println("Sisesta password");

        //salvesta sisend muutujasse password
        String password = sisend.next();

        if (password.equals(oigePassword)) {
            System.out.println("Tule sisse");
        } else {
            System.err.println("Vale parool");
        }
    }
}
