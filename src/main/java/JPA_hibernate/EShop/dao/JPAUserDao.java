package JPA_hibernate.EShop.dao;

import JPA_hibernate.EShop.exceptions.NoUserFoundException;
import JPA_hibernate.EShop.model.User;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class JPAUserDao {

    private static final Logger LOG = Logger.getLogger(JPAUserDao.class);
    private EntityManagerFactory factory;

    public JPAUserDao(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public User create(User user){
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try{
            transaction.begin();
            manager.persist(user);
            transaction.commit();
        }catch(Throwable th){
            LOG.error(th);
            transaction.rollback();
        }finally {
            manager.close();
        }
        return user;
    }

    public User find(int id) throws NoUserFoundException {
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        try{
            User found = manager.find(User.class, id);

            if (found != null)
                return found;
            else
                throw new NoUserFoundException("user with id " + id + "does not exist");
        }finally {
            manager.close();
        }
    }

    public User find(String email) throws NoUserFoundException {
        EntityManager manager = factory.createEntityManager();

        TypedQuery<User> typedQuery =
                manager.createQuery("Select u FROM User u WHERE u.email = :email", User.class);
        User user = typedQuery.setParameter("email", email).getSingleResult();

        if (user != null)
            return user;
        throw new NoUserFoundException("user with email " + email + "does not exist");
    }

    public List<User> findAll(){
        EntityManager manager = factory.createEntityManager();

        TypedQuery<User> typedQuery =
                manager.createQuery("Select u FROM User u", User.class);
        return typedQuery.getResultList();
    }

    public User update(User user){
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        User found = null;
        try{
            transaction.begin();
            found = manager.find(User.class, user.getId());

            found.setUserType(user.getUserType());
            found.setEmail(user.getEmail());
            found.setFullname(user.getFullname());
            found.setPass(user.getPass());
            found.setPhone(user.getPhone());

            manager.merge(found);
            transaction.commit();
        }catch(Throwable th){
            LOG.error(th);
            transaction.rollback();
        }finally {
            manager.close();
        }
        return found;
    }

    public boolean delete(User user){
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        User found = null;
        try{
            transaction.begin();
            found = manager.find(User.class, user.getId());
            manager.remove(found);
            transaction.commit();
        }catch(Throwable th){
            LOG.error(th);
            transaction.rollback();
            return false;
        }finally {
            manager.close();
        }
        return true;
    }
}
