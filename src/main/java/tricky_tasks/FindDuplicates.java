package tricky_tasks;

import java.util.*;

//O(n)
public class FindDuplicates {
    public static void main(String[] args) {
        String[] names = {"Java", "JavaScript", "Python", "C", "Ruby", "Java", "C"};
        betterWay(names);
    }

    private static void oneWay(String names[]) {
        Map<String, Integer> map = new HashMap<>();
        for (String name :
                names) {
            if (map.get(name) == null)
                map.put(name, 1);
            else {
                int count = map.get(name);
                map.put(name, ++count);
            }
        }

        for (Map.Entry<String, Integer> entry :
                map.entrySet()) {
            if (entry.getValue() > 1)
                System.out.println(entry.getKey());
        }
    }

    private static void betterWay(String names[]) {
        Set<String> map = new HashSet<>();
        for (String name :
                names) {
            if (map.add(name) == false)
                System.out.println(name);
        }
    }
}
