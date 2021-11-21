import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class WordsFrequency {

    String path = new String("path");

    Map<String, Long> freq = new HashMap<>();
        Stream<String> words = new Scanner(path).tokens(); {
        words.forEach(word -> {
            freq.merge(word.toLowerCase(), 1L, Long::sum);
        });
    }
}

class WordsFrequencyButBetter{
    String path = new String("path");


    Map<String, Long> freq;
    Stream<String> words = new Scanner(path).tokens(); {
        freq = words
                .collect(groupingBy(String::toLowerCase, counting()));
    }

    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }

}
