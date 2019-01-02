package reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation {
    String key();
    String value();
}

public class MyAnnotationTest {

    @MyAnnotation(key = "site", value = "java2novice.com")
    public void myAnnotationTestMethod() {
        try {
            Class<?> cls = this.getClass();
            Method mth = cls.getMethod("myAnnotationTestMethod");
            MyAnnotation myAnno = mth.getAnnotation(MyAnnotation.class);
            System.out.println("key: " + myAnno.key());
            System.out.println("value: " + myAnno.value());
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        MyAnnotationTest mat = new MyAnnotationTest();
        mat.myAnnotationTestMethod();
    }
}