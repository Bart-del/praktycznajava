import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        List<String> strings1 = List.of("Uno", "Dos");
        List<String> strings2 = List.of("Cuatro", "Cinco");

        varargs(strings1, strings2);

    }

    public static void arraysAndTypes()
    {
        Object[] objects = new Long[2];
        objects[0] = "Tu nie powinno być Stringa";
    }

    /*
    public static void arraysAndTypes2()
    {
        List<Object> objects = new ArrayList<Long>();
        objects.add("Tu nie powinno być Stringa");
    }

     */

    @SafeVarargs
    public static void varargs(List<? extends String>... stringsList)
    {
        for (List<? extends String> list : stringsList)
        {
            for (String str : list)
            {
                System.out.println(str);
            }
        }
    }
}
