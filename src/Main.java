import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Main {
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);

        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    public static void findEvenNumbers (List<Integer> list) {
        Stream<Integer> stream = list.stream();
        Predicate<Integer> predicate = (n) -> (n%2) == 0;
        Stream<Integer> resStream = stream.filter(predicate);
        System.out.println("Количество четных чисел: " + resStream.count());
    }

    public static void main(String[] args) {
        
        Stream<Integer> stream = Stream.of(5, 18, 3, 43, 7, 13, 58);

        findMinMax(
                stream,
                (x, y) -> x.compareTo(y),
                (x, y) -> System.out.println(String.format("min: %s, max: %s", x, y))
        );

        System.out.println("-----------------------------------------");

        List<Integer> list1 = new ArrayList<Integer>();
        int number;
        Random rnd = new Random();

        for (int i=0; i<10; i++) {
            number = rnd.nextInt() % 100;
            list1.add(number);
        }
        System.out.println(list1);
        findEvenNumbers(list1);
    }

}

