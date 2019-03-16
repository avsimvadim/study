package spring.ioc.dao;


import spring.ioc.db.AppDB;
import spring.ioc.model.MyUser;

public class GeneralDao {

    private AppDB db;

    public GeneralDao() {
    }

    public MyUser find(String email) {
        return db.getUserMap().get(email);
    }

    public AppDB getDb() {
        return db;
    }

    public void setDb(AppDB db) {
        this.db = db;
    }
}
