package spring.borisov;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//how much time method works
@Retention(RetentionPolicy.RUNTIME)
public @interface Profiling {
}
