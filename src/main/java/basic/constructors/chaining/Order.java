package basic.constructors.chaining;

public class Order {
    public int i;

    Order(){
        System.out.println("order");
    }

    Order(int i){
        this.i = i;
        System.out.println("order i");
    }
}

class ChildOrder extends Order{
    public int i;

    ChildOrder(){
        System.out.println("child order");
    }

    ChildOrder(int i){
        this.i = i;
        System.out.println("child order i");
    }
}

class ChildChildOrder extends ChildOrder{
    public int i;

    ChildChildOrder(){
        System.out.println("Childchild order");
    }

    ChildChildOrder(int i){
        this.i = i;
        System.out.println("Childchild order i");
    }

    public static void main(String[] args) {
        ChildChildOrder co = new ChildChildOrder();
        System.out.println();
        ChildChildOrder co2 = new ChildChildOrder(1);
    }
}
