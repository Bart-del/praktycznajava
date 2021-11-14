import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

    public void printDatesTest(){

        LocalDate startDate = LocalDate.of(2021,1,1);

        Stream.iterate(startDate,date -> date.plusDays(1))
                .peek(System.out::println)
                .allMatch(date->date.isBefore(LocalDate.now()));

        Stream.iterate(startDate,date ->
                        date.isBefore(LocalDate.now()),  date -> date.plusDays(1))
                .forEach(System.out::println);
    }

    public void runTestJava9(){

        Stream.iterate("", a -> a + "a")
                .takeWhile(a->a.length() < 3)
                .forEach(System.out::println);
        System.out.println("-----------------------------");

        Stream.iterate("", a -> a + "a")
                .dropWhile(a->a.length() < 3)
                .forEach(System.out::println);

    }

    public void runTest() {

        List<Product> products =
                Arrays.asList(
                        new Product(1, 1500d, "Table", Product.Type.TABLE),
                        new Product(2, 900d, "Chair", Product.Type.CHAIR),
                        new Product(3, 1100d, "Board", Product.Type.BOARD)
                );


        products
                .stream()
                .map(Product::getType)
                .forEach(System.out::println);

        System.out.println("\n");
        //----------------------------------------

        final List<List<Product>> nestedProductsList = Arrays.asList(
                Arrays.asList(
                        new Product(1,500d,"Table", Product.Type.TABLE),
                        new Product(2,560d,"Table", Product.Type.TABLE)
                ),
                Arrays.asList(
                        new Product(3,900d,"Chair", Product.Type.CHAIR),
                        new Product(4, 150d, "Chair", Product.Type.CHAIR)
                ),
                Arrays.asList(
                        new Product(5, 740d, "Board", Product.Type.BOARD),
                        new Product(6, 805d,"Board", Product.Type.BOARD)
                )
        );

        final List<Product> simpleProductList =
                nestedProductsList
                        .stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());

        System.out.println("nested products list: " + nestedProductsList);
        System.out.println("simple products list: " + simpleProductList);



        //------------------------------------------

        Predicate<Product> pricePredicate = product -> product.getPrice() > 1000d;

        List<Product> filteredProductLit =
                products
                        .stream()
                        .filter(pricePredicate)
                        .collect(Collectors.toList());


        Map<Integer,Product> productMap =
                products
                        .stream()
                        .limit(2)
                        .collect(Collectors.toMap(
                                Product::getId,
                                Function.identity(),
                                (key1, key2) -> {
                                    throw new IllegalStateException(
                                            String.format("Duplicate key value %s", key1));}
                        ));


        Map<Product.Type, List<Product>> productGroupedByType =
                products
                        .stream()
                        .collect(Collectors.groupingBy(Product::getType));


        final int size = 1;

        AtomicInteger counter = new AtomicInteger(0);

        Stream<List<Product>> productListStream =
                products
                        .stream()
                        .collect(Collectors.groupingBy(product -> counter.getAndIncrement()/size))
                        .values()
                        .stream();

        List<List<Product>> chunkProductList =
                productListStream
                        .collect(Collectors.toList());

        System.out.println(chunkProductList);

        DoubleSummaryStatistics priceSummarising =
                products
                        .stream()
                        .collect(Collectors.summarizingDouble(Product::getPrice));

        System.out.println(priceSummarising);


        String chairTypeProducts =
                products
                        .stream()
                        .filter(product -> product.getType().equals(Product.Type.CHAIR))
                        .map(product -> Integer.toString(product.getId()))
                        .collect(Collectors
                                .joining(" , ", "Products with id's: "," are chairs"));

        System.out.println(chairTypeProducts);

        Double priceSumForAllProducts =
                products
                        .stream()
                        .map(Product::getPrice)
                        .reduce(0.0, Double::sum);

        final List<Double> prices = Collections.synchronizedList(new ArrayList<>());

        products
                .parallelStream()
                .forEach(product -> {
                    if(product.getPrice() > 1000d){
                        prices.add(product.getPrice());
                        System.out.println(prices);
                    }
                });



    }
}




