package main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kristina on 27.10.16.
 */
public class hashMapid {
    public static void main(String[] args) {
        /*HashMap<String, ArrayList> hash = new HashMap();

        ArrayList<String> list = new ArrayList();
        list.add("Tere");
        list.add("Hola");


        hash.put("hello", list);

        hash.get("hello").add("Namaste");
        System.out.println(hash);*/

        HashMap<String, HashMap<String, String>> dictionary = new HashMap();
        HashMap<String, String> translation = new HashMap();

        translation.put("en", "Hello");
        translation.put("et", "Tere");
        translation.put("es", "Hola");
        translation.put("hi", "Namaste");

        dictionary.put("hello", translation);

        translation = new HashMap();

        translation.put("en", "House");
        translation.put("et", "Maja");
        translation.put("es", "Casa");
        translation.put("hi", "Ghar");

        dictionary.put("house", translation);
        System.out.println(dictionary);


    }
}
