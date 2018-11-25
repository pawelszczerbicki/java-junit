package tutorial.junit.sandbox;

import java.util.ArrayList;

public class ArrayExamples<T> {
    T some;

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();
        names.add("dsadsaas");
        names.add("dsh");
        names.add("hyiuoiuy");
        names.add("fgreyrtg");

        names.get(10);

        System.out.println(names.isEmpty());
        
        for (String name : names) {
            System.out.println(name);
        }

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            System.out.println(name);
        }




    }
}
