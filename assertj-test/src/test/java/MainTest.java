import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class MainTest {

    public void testOne(){
        assertThat(new File("Some Path")).canRead();
    }


    public void objectAssertion(){
        Product product = new Product("Chair", 55.99);
        Product productClone = new Product("Chair", 55.99);

        assertThat(product).isEqualTo(productClone);

        assertThat(product).isEqualToComparingFieldByFieldRecursively(productClone);
    }

    public void booleanAssertion(){
        boolean bol = false;

        assertThat(bol).isTrue();
    }

    public void iterableAssertion(){

        List<String> list = Arrays.asList("1", "2", "3");
        assertThat(list).contains("1");

        assertThat(list)
                .isNotEmpty()
                .contains("2")
                .doesNotContainNull()
                .containsSequence("1", "2", "3");
    }

    public void charAssertion(){

        char someCharacter = 'a';
        assertThat(someCharacter)
                .isNotEqualTo('a')
                .inUnicode()
                .isGreaterThanOrEqualTo('b')
                .isLowerCase();
    }

    public void classAssertion(){

        assertThat(SomeClass.class).isFinal();

    }

    public void fileAssertion(){

        File someFile = new File("Some path");
        assertThat(someFile)
                .exists()
                .isFile()
                .canRead()
                .canWrite();
    }

    public void numbersAssertion(){

        assertThat(6.1).isEqualTo(6, withPrecision(1d));
    }

    public void mapAssertion(){
        Map<Integer, String> map = new HashMap();
        map.put(2,"a");

        assertThat(map)
                .isNotEmpty()
                .containsKey(2)
                .doesNotContainKeys(10)
                .contains(entry(2, "a"));
    }

    public void throwAssertion(){
        Throwable ex = new Throwable("Message d");

        assertThat(ex).hasNoCause().hasMessageEndingWith("d");
    }

    public void describeAssertion(){
        Product product = new Product("Chair", 154.99);

        assertThat(product.getPrice())
                .as("%s's price should be below 100", product.getName())
                .isLessThan(100);
    }
}
