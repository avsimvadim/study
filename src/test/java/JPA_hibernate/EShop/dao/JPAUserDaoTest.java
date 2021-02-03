package JPA_hibernate.EShop.dao;

import JPA_hibernate.EShop.exceptions.NoUserFoundException;
import JPA_hibernate.EShop.model.Product;
import JPA_hibernate.EShop.model.User;
import org.junit.*;
import org.junit.runners.MethodSorters;

import javax.persistence.Persistence;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JPAUserDaoTest {

    private static JPAUserDao dao;

    @BeforeClass
    public static void setUp(){
        dao = new JPAUserDao(Persistence.createEntityManagerFactory("EShop-unit"));
    }
    @Test
    public void _01create() {
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
    public void _02findUserById() {
        List<User> all = dao.findAll();
        User user = all.get(all.size() - 1);
        try {
            Assert.assertNotNull(dao.find(user.getId()));
        }catch(NoUserFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void _04addUserWithProduct(){
        String email = System.currentTimeMillis() + "myemail.gmail.com";
        User user = new User(email, "user test fullname", "+380648825573", "1234");

        Product product1 = new Product("name1", 300.0, "title1", "desc", user);
        Product product2 = new Product("name2", 400.0, "title3", "dvdfvesc", user);

        user.getProducts().add(product1);
        user.getProducts().add(product2);

        dao.create(user);
        try {
            Assert.assertEquals(dao.find(email).getProducts().size(), 2);
        }catch(NoUserFoundException e){
            e.printStackTrace();
        }

    }

    @Ignore
    @Test
    public void findAll() {
    }

    @Ignore
    @Test
    public void update() {
    }

    @Test(expected = NoUserFoundException.class)
    public void _03delete() throws NoUserFoundException{
        List<User> all = dao.findAll();
        User forDelete = all.get(all.size() - 1);
        dao.delete(forDelete);
        dao.find(forDelete.getId());
    }

}
