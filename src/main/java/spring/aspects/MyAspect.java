package spring.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    //@Before("execution(public * spring.aspects.Service.addStudent(*))")
    public void addStudentBeforeAdvice(JoinPoint joinPoint){
        System.out.println("Before service advice" + joinPoint.getSignature());
    }

    //@After("execution(public * spring.aspects.Service.addStudent(*))")
    public void addStudentAfterAdvice(JoinPoint joinPoint){
        System.out.println("After service advice " + joinPoint.getSignature());
    }

    //@AfterReturning(pointcut = "execution(public * spring.aspects.Service.addStudent(*))", returning = "status")
    public void addStudentAfterReturningAdvice(Object status){
        System.out.println("After Returning service advice " + status);
    }

    //@Around("execution(public * spring.aspects.Service.*(*))")
    public Object addStudentAdvice(ProceedingJoinPoint joinPoint){
        System.out.println("Before service advice" + joinPoint.getSignature());
        Object res = null;
        try {
            res = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("after proceeded");
        return res;
    }
}
