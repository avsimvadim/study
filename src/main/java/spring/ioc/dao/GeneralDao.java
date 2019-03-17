package spring.ioc.dao;


import spring.ioc.common.Inject;
import spring.ioc.db.AppDB;
import spring.ioc.model.MyUser;

public class GeneralDao {

    @Inject
    private AppDB db;
    private String name;

    public GeneralDao() {
    }

    public GeneralDao(AppDB db, String name) {
        this.db = db;
        this.name = name;
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
