import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        test();
        testForEach();
    }

    public static void test(){

        try {
            int var = 14;
        }
        catch (Exception e){
            System.out.println(e);
        }

        var += 10;
    }

    public static void testForEach(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Cześć! ");
        list.add("Tu ");
        list.add("praktyczna ");
        list.add("Java");

        for(String e : list){
            System.out.println(e);
        }
    }
}
