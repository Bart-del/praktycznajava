import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Methods {
    private Object strategy;
    private List<Product> productsInStock;

    /**
     * Zwraca Double, którego wartość to wynik dzielenia divident przez divisor.
     *
     * @param divisor, który zawsze musi być dodatni
     * @return this Double
     * @throws ArithmeticException, jeżeli divisor jest równe 0
     */
    public Double divide(Double divident, Double divisor) {
        if (divisor == 0)
            throw new ArithmeticException("Dzielnik jest równy 0. Nie można dzielić przez zero");

        return divident / divisor;
    }

    public void update(Object strategy){
        this.strategy = Objects.requireNonNull(strategy, "Strategy is null");
    }

    public void doSomeAction(int length) {
        int startIndex = 0;
        int endIndex = 20;
        Objects.checkFromToIndex(startIndex, endIndex, length);

        //dalsza część metody...
    }

    static int min(int... args) {
        if (args.length == 0)
            throw new IllegalArgumentException("Za mało argumentów");
        int min = args[0];
        for (int i = 1; i < args.length; i++)
            if (args[i] < min)
                min = args[i];
        return min;
    }

    static int min(int firstArgument, int... remainingArgs) {
        int min = firstArgument;
        for (int arg : remainingArgs)
            if (arg < min)
                min = arg;
        return min;
    }


    public List<Product> getProducts() {
        return productsInStock.isEmpty() ? Collections.emptyList()
                : new ArrayList<>(productsInStock);
    }



    class Product{

    }
}


