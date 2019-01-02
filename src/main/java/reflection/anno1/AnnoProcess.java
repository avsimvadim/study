package reflection.anno1;

import java.lang.reflect.Method;

public class AnnoProcess {
    public static void main(String[] args) {
        inspectService(SimpleService.class);
        inspectService(LazyService.class);
        //inspectService(String.class);
    }

    static void inspectService(Class<?> service){
//        if (service.isAnnotationPresent(Service.class)){
//            Service ann = service.getAnnotation(Service.class);
//            System.out.println(ann.name());
//        } else {
//            System.out.println("not found, class " + service);
//        }
        Method[] methods = service.getDeclaredMethods();
        for (Method method: methods){
            if (method.isAnnotationPresent(Init.class)){
                System.out.println(method.getAnnotations()[0].toString() + method.getName() + " Init");
            } else {
                System.out.println(method.getName() + " not found");
            }
        }

    }
}
