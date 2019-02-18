package generics.example1;

public class GenDemo {
    public static void main(String[] args) {
        Gen<Integer> gen1 = new Gen<>(10);
        gen1.showType();

        Gen<String> gen2 = new Gen<>("hello");
        gen2.showType();
    }
}

class Gen<T>{
    T ob;

    public Gen(T ob) {
        this.ob = ob;
    }

    T getOb(){
        return ob;
    }

    void showType(){
        System.out.println("Type T is " + getOb().toString());
    }
}
