package java8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5, 30);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                .map(x -> x * x)
                .filter(x -> x % 3 == 0)
                .findAny();
        System.out.println(firstSquareDivisibleByThree);

        //Optional usage
        Car car = new Car();

        //traditional way
        String name = null;
        if(car != null){
            name = car.getName();
        }
        //new way
        Optional<Car> optCar = Optional.ofNullable(car);
        Optional<String> name2 = optCar.map(Car::getName);

        //optional from a non-null value
        Optional<Car> optCar4 = Optional.of(car);
        System.out.println(optCar4.get());

        //empty Optional
        Optional<Car> optCar2 = Optional.empty();
        System.out.println(optCar2.isPresent());

        car = null;
        //Optional object that may hold a null value
        Optional<Car> optCar3 = Optional.ofNullable(car);
        System.out.println(optCar3);


    }
}
