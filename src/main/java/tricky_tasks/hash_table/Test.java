package tricky_tasks.hash_table;

public class Test {
    public static void main(String[] args) {
        HashTable<Integer,String> table = new HashTable<>();
        table.put(1,"11");
        table.put(2,"22");
        table.put(11,"33");

        System.out.println(table.get(11));
    }
}
