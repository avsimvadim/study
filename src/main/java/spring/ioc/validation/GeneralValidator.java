package spring.ioc.validation;

public class GeneralValidator {
    public boolean isValidate(String email) {
        return email != null && email.contains("@");
    }

    public boolean isValidPass(String pass) {
        return pass != null && pass.length() >= 8;
    }
}
