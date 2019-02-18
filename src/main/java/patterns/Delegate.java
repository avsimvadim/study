package patterns;

//the delegation pattern is an object-oriented design pattern
//that allows object composition to achieve the same code reuse as inheritance.
//In delegation, an object handles a request by delegating to a second object (the delegate).
public class Delegate {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setAnimal(new Dog());
        customer.show();

        customer.setAnimal(new Parrot());
        customer.show();
    }
}

interface Animal{
    void show();
}

class Dog implements Animal{
    @Override
    public void show() {
        System.out.println("DOG");
    }
}

class Parrot implements Animal{
    @Override
    public void show() {
        System.out.println("Parrot");
    }
}

class Customer{
    Animal animal;

    public void setAnimal(Animal animal){
        this.animal = animal;
    }

    public void show(){
        animal.show();
    }
}