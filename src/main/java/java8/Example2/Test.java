package java8.Example2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Created by serhii on 04.02.18.
 */
public class Test {
    public static void main(String[] args) {
        //init
        ArrayList<User> userList = new ArrayList<>();

        Department it = new Department(1,"IT","KIEV");
        Department support = new Department(2,"SUPPORT","KIEV");
        Department test = new Department(3,"TEST","ODESSA");
        Department man = new Department(4,"MAN","ODESSA");

        userList.add(new User(1,"Kolia", 3000, it));
        userList.add(new User(2,"Oleg", 2000, test));
        userList.add(new User(3,"Ivan", 5000, it));
        userList.add(new User(4,"Olesia", 1000, support));
        userList.add(new User(5,"Petro", 2500, test));
        userList.add(new User(6,"Jenia", 3500, support));
        userList.add(new User(7,"Jenia", 3700, man));

        //test
        topBySalaryWithLimit(userList,4).stream().forEach(System.out::println);
        System.out.println();
        groupByDepartment(userList).forEach((d,l) -> System.out.println(d + ": " + l.toString()));
        System.out.println();
        groupByDepartmentWithSumOfSalaries(userList).forEach((s,l) -> System.out.println(s + ": " + l.toString()));
        System.out.println();
        groupByCityName(userList).forEach((c,l) -> System.out.println(c + ": " + l.toString()));
        System.out.println();
        System.out.println(amountOfAllSalariesUsingReduce(userList));

    }

    public static List<User> topBySalaryWithLimit(List<User> list, int limit){
        return list.stream()
                .sorted(Comparator.comparingDouble(User::getMoney))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static Map<Department, List<User>> groupByDepartment(List<User> list){
        return list.stream().collect(groupingBy(User::getDepartment));
    }

    public static Map<Department, Double> groupByDepartmentWithSumOfSalaries(List<User> list){
        return list.stream().collect(groupingBy(User::getDepartment, summingDouble(User::getMoney)));
    }

    public static Map<String, List<User>> groupByCityName(List<User> list){
        return list.stream().collect(groupingBy(u -> u.getDepartment().getCity()));
    }

    public static Double amountOfAllSalariesUsingReduce(List<User> list){
        return list.stream().collect(reducing(0.0, User::getMoney, Double::sum));
    }

}
