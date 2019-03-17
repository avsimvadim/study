package spring.ioc.test;

import spring.ioc.dao.GeneralDao;
import spring.ioc.di.DependencyInjector;
import spring.ioc.model.MyUser;

public class TestDI {
    public static void main(String[] args) {
        DependencyInjector dependencyInjector = new DependencyInjector();
        GeneralDao generalDao = new GeneralDao();

        dependencyInjector.inject(generalDao);

        MyUser myUser = generalDao.find("123@gmail.com");

        System.out.println(myUser);
    }
}
