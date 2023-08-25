package basic.constructors.chaining;

class BaseBase{
    String name;

    BaseBase() {
        System.out.println("No-argument constructor of BaseBase class");
    }

    BaseBase(String name) {
        this.name = name;
        System.out.println("Calling parameterized constructor of BaseBase");
    }
}

class Base extends BaseBase{
    String name;

    Base() {
        //this("");
        System.out.println("No-argument constructor of Base class");
    }

    Base(String name) {
        this.name = name;
        System.out.println("Calling parameterized constructor of Base");
    }
}

class Derived extends Base {
    Derived() {
        System.out.println("No-argument constructor of derived");
    }

    Derived(String name) {
        super(name);
        System.out.println("Calling parameterized constructor of derived");
    }

    public static void main(String args[]) {
        Derived obj = new Derived("test");
        System.out.println();
        //Derived obj2 = new Derived();
    }
}

