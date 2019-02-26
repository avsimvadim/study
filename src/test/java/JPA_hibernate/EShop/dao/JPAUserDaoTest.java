package JPA_hibernate.EShop.dao;

import JPA_hibernate.EShop.exceptions.NoUserFoundException;
import JPA_hibernate.EShop.model.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class JPAUserDaoTest {

    private static JPAUserDao dao;

    @BeforeClass
    public static void setUp(){
        dao = new JPAUserDao(Persistence.createEntityManagerFactory("EShop-unit"));
    }
    @Test
    public void create() {
        String email = System.currentTimeMillis() + "myemail.gmail.com";
        User user = new User(email, "user test fullname", "+380648825573", "1234");
        dao.create(user);

        try{
            User found = dao.find(email);
            Assert.assertEquals(found.getEmail(), email);
        }catch (NoUserFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void findUserByEmail() {
    }

    @Test
    public void findUserById() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}