package spring.ioc.test;

import spring.ioc.service.MyService;
import spring.ioc.dao.GeneralDao;
import spring.ioc.db.AppDB;
public class ServiceLocator {

    private final AppDB db;
    private MyService myService;
    private final GeneralDao genDao;

    public ServiceLocator(){
        myService = new MyService();
        genDao = new GeneralDao();
        db = new AppDB();
        genDao.setDb(db);
        myService.setGenDao(genDao);
    }

    public Object get(String name) {
        if ("myService".equals(name)){
            return myService;
        }
        return null;
    }
}
