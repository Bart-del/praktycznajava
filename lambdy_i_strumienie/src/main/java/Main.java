import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        class LocalInnerClass{
            void print(){
                System.out.println("Klasa wewnętrzna");
            }
        }
        new LocalInnerClass().print();

        LocalInnerClass anonymousClass = new LocalInnerClass(){
            @Override
            void print(){
                System.out.println("Klasa anonimowa");
            }
        };
        anonymousClass.print();

        interface Greeting{
            void hello();
        }

        Greeting anonymousGreeting = new Greeting() {
            @Override
            public void hello() {
                System.out.println("Witaj!");
            }
        };

        ArrayList<String> words = new ArrayList<>();

        Collections.sort(words, new Comparator<String>() {
            public int compare(String str1, String str2) {
                return Integer.compare(str1.length(), str2.length());
            }
        });

        Collections.sort(words,
                (str1, str2) -> Integer.compare(str1.length(),str2.length()));

        Collections.sort(words,
                Comparator.comparingInt(String::length));
    }
}

