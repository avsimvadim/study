package patterns.strategy;

public class Main {
    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        System.out.println(b1);

        Validator lowerCaseValidator = new Validator(new IsAllLowerCase ());
        boolean b2 = lowerCaseValidator.validate("bbbb");
        System.out.println(b2);

        //we can use functional interface
        Validator numericValidator2 = new Validator((String s) -> s.matches("[a-z]+"));
        boolean b12 = numericValidator.validate("aaaa");

        Validator lowerCaseValidator2 = new Validator((String s) -> s.matches("\\d+"));
        boolean b22 = lowerCaseValidator.validate("bbbb");
    }
}
