package spring.ioc.test;

import spring.ioc.dao.GeneralDao;
import spring.ioc.db.AppDB;
import spring.ioc.service.MyService;

public class TestInitTask {
    public static void main(String[] args) {
        ServiceLocator serviceLocator = new ServiceLocator();
        MyService myService = (MyService) serviceLocator.get("myService");


        //problem
//        MyService myService = new MyService();
//        GeneralDao genDao = new GeneralDao();
//        genDao.setDb(new AppDB());
//        myService.setGenDao(genDao);
    }

}
