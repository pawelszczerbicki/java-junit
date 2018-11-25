package tutorial.junit.sandbox;

class Main {

    static {
        System.out.println("dsdsadsa");
    }

    public static void main(String[] args) {
        System.out.println("Hello world");
        int a = 22;
        double b = 22.2222;
        float c = 2.333f;
        boolean d = true;
        char e = 65;
        char f = 'A';


        String some = "some String";
        String other = some.toUpperCase();

//        System.out.println(some == other);

        Person p1 = new Person("", "");
        Person p2 = new Person("", "");

//        System.out.println(p1 == p2);

        String z = new String("a");
        String y = "a";

//        System.out.println(z==y);

        Integer first = 128;
        Integer second = 128;

        System.out.println(first == second);

        Integer[] digits = {1, 2, 3, 4, 5, 6};
        Integer[] arrayExamole2 = new Integer[10];

        for (int i = 0; i < digits.length; i++) {
            if (isEven(digits[i]) && isFirstHalf(i, digits))
                System.out.println(digits[i]);

            if (!isEven(digits[i]) && !isFirstHalf(i, digits))
                System.out.println(digits[i]);
        }




    }

    private static boolean isFirstHalf(int i, Integer[] digits) {
        return i < digits.length / 2;
    }

    private static boolean isEven(int digit) {
        return digit % 2 == 0;
    }


    public int add(int a, int b) {
        return 1;
    }

    public int add(int a, double b) {
        return 1;
    }

    public int add(double b, int a) {
        return 1;
    }

    public int add(int a, int b, int c) {
        return 1;
    }
}

