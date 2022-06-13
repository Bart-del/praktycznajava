import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static Scheduler scheduler = Schedulers.from(Executors.newFixedThreadPool(2));

    public static void main(String[] args) throws InterruptedException {


        Observable
                .range(1, 10)
                .filter(i -> i % 2 == 0)
                .map(i -> i * 10)
                .subscribe(System.out::println);






       // Observable<String> emiter = Observable.just(
        //        "Praktyczna java",
        //        "Prakrtczna java 2",
        //        "Praktyczna java 3");
        //emiter.subscribe(System.out::println);

        Flowable<Stock> appl = rxStockPrice("APPL");
        Flowable<Stock> tsla = rxStockPrice("TSLA");

        Flowable.merge(appl, tsla)
                .subscribe(sp -> System.out.println(sp.toString()));

        Observable<Integer> myObservable;
        myObservable = Observable.create(emitter -> {
            AtomicInteger counter = new AtomicInteger(0);
            for (;;) {
                int current = counter.getAndIncrement();
                if (current > 100)
                    emitter.onComplete();
                else {
                    emitter.onNext(current);
                    Thread.sleep(100);
                }
            }
        });

        myObservable
                .map(Object::toString)
                .subscribe(System.out::println);
    }

    public static Flowable<Stock> rxStockPrice(String code) {
        return Flowable
                .fromCallable(() -> traditionalStockPrice(code))
                .subscribeOn(scheduler);
    }
    public static Stock traditionalStockPrice(String code) throws InterruptedException {
        System.out.println("Getting stock price for " +  code);
        Thread.sleep(1000);
        return new Stock(code, 312);
    }
}
