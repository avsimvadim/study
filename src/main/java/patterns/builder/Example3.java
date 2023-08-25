package patterns.builder;

public class Example3 {
    public static void main(String[] args) {
        Car car = new Car.Builder()
                .make("Audi")
                .build();
        System.out.println(car);
    }
}

class Car{
    private int age;
    private String make;

    public Car(Builder builder){
        this.age = builder.age;
        this.make = builder.make;
    }

    @Override
    public String toString() {
        return "Car{" +
                "age=" + age +
                ", make='" + make + '\'' +
                '}';
    }

    static class Builder{
        private int age = -1;
        private String make = "";

        public Builder age(int age){
            this.age = age;
            return this;
        }

        public Builder make(String make){
            this.make = make;
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }

}