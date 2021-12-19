import com.google.common.collect.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        unionTest();
    }

    public static void multisetCountTest(){
        Multiset<String> newsletters = HashMultiset.create();
        newsletters.add("Praktyczna Java");
        newsletters.add("Praktyczna Java");
        newsletters.add("Praktyczna Java");

        newsletters.setCount("Praktyczna Java", 3);
    }

    public static void multisetForEachEntryTest(){
        Multiset<String> multiset = HashMultiset.create();
        multiset.forEachEntry((fruit, c) -> System.out.println(fruit + " appears " + c + " times"));
    }

    public static void multisetContainsAllTest(){
        Multiset<String> multiset = HashMultiset.create();
        System.out.println(multiset.containsAll(Arrays.asList("orange", "apple", "orange", "orange")));
    }

    public static void multimapKeySetTest(){
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("Praktyczna", "Java");
        multimap.put("Praktyczna", "Nauka");

        System.out.println(multimap.keySet());// Wyświetli "[Praktyczna]"
    }

    public static void multimapEntriesTest(){
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("Praktyczna", "Java");
        multimap.put("Praktyczna", "Nauka");

        System.out.println(multimap.entries());// Wyświetli "[Praktyczna=Java, Praktyczna=Nauka]"
    }

    public static void multimapContainEntryTest(){
        Multimap<String, String> multimap = ArrayListMultimap.create();
        multimap.put("Praktyczna", "Java");
        multimap.put("Praktyczna", "Nauka");

        System.out.println(multimap.containsEntry("Praktyczna", "Java"));
        // Wyświetli wartość true"
    }

    public static void bimapInverseTest(){
        BiMap<String, String> capitalCountryBiMap = HashBiMap.create();
        capitalCountryBiMap.put("New Delhi", "India");
        capitalCountryBiMap.put("Washington, D.C.", "USA");
        capitalCountryBiMap.put("Moscow", "Russia");

        String keyFromBiMap = capitalCountryBiMap.inverse().get("Russia");

        System.out.println(keyFromBiMap); // Wyświetli "Moscow"
    }

    public static void bimapCreateFromEnumTest(){
        BiMap<Languages, Integer> capitalCountryBiMap = EnumHashBiMap.create(Languages.class);
        capitalCountryBiMap.put(Languages.ENGLISH,14);
        capitalCountryBiMap.put(Languages.POLISH, 32);
        System.out.println(capitalCountryBiMap.entrySet());
    }

    public static void bimapBuilderTest(){
        ImmutableBiMap<Object, Object> capitalCountryBiMap
                = new ImmutableBiMap.Builder<>()
                .put("New Delhi", "India")
                .build();
    }

    public static void tableContainColumnTest(){
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        System.out.println(universityCourseSeatTable.containsColumn("IT"));// Zwraca true
    }

    public static void tableContainRowTest(){
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        System.out.println(universityCourseSeatTable.containsColumn("Harvard")); // Zwraca true
    }

    public static void tableColumnKeySetTest(){
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        System.out.println(universityCourseSeatTable.columnKeySet()); // Zwraca [Chemical, IT, Electrical]
    }

    public static void addIgnoreNullTest(){
        List<String> list = new LinkedList<String>();
        CollectionUtils.addIgnoreNull(list, null);
        CollectionUtils.addIgnoreNull(list, "a");

        System.out.println(list); // Wyświetli [a]
    }

    public static void collateTest() {
        List<String> list1 = Arrays.asList("Java", "Praktyczna");
        List<String> list2 = Arrays.asList("Apache", "Commons");

        List<String> sortedList = CollectionUtils.collate(list1, list2);

        System.out.println(sortedList); //Wyświetli [Apache, Commons, Java, Praktyczna]
    }

    public static void transformTest(){
        List<Customer> list1 = new ArrayList<>();
        list1.add(new Customer("Jan", new Address("Poznań ...")));
        list1.add(new Customer("Mateusz", new Address("Warszawa...")));
        list1.add(new Customer("Wojciech", new Address("Gdynia ...")));

        Collection<Address> addressCol = CollectionUtils.collect(list1,
                new Transformer<Customer, Address>() {
                    public Address transform(Customer customer) {
                        return customer.getAddress();
                    }
                });

    }

    public static void filterTest(){

        List<Customer> linkedList1 = new LinkedList<>();
        linkedList1.add(new Customer("Daniel", new Address("Poznań...")));
        linkedList1.add(new Customer("Adam", new Address("Warszawa...")));

        boolean isModified = CollectionUtils.filter(linkedList1,
                new Predicate<Customer>() {
                    public boolean evaluate(Customer customer) {
                        return Arrays.asList("Daniel","Kyle").contains(customer.getName());
                    }
                });
    }

    public static void isSubCollectionTest() {
        List<String> list3 = Arrays.asList("Java");
        List<String> list1 = Arrays.asList("Praktyczna", "Java");
        System.out.println(CollectionUtils.isSubCollection(list3, list1));// Zwróci true
    }

    public static void unionTest() {
        List<String> list1 = Arrays.asList("Java", "Praktyczna");
        List<String> list2 = Arrays.asList("Apache", "Commons");

        Collection<String> union = CollectionUtils.union(list1, list2);

        System.out.println(union); // Wyświetli [Java, Commons, Praktyczna, Apache]

    }
}

