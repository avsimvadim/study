package spring.ioc.di;

import spring.ioc.common.Inject;
import spring.ioc.db.AppDB;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DependencyInjector {

    private Map<String, Object> context;

    public DependencyInjector(){
        context = new HashMap<>();
        context.put("spring.ioc.db.AppDB", new AppDB());
    }

    public void inject(Object target){
        Class cl = target.getClass();

        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(Inject.class)){
                String typeName = field.getType().getTypeName();
                //do injection
                Object injectObj = context.get(typeName);
                try{
                    field.set(target, injectObj);
                } catch(IllegalAccessException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
