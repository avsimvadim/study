package JPA_hibernate.example1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class TestCRUD {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("example1-unit");
        EntityManager manager = entityManagerFactory.createEntityManager();

        Client client1 = new Client("Vadym");
        Client client2 = new Client("Dima");
        Client client3 = new Client("Serhii");

        persist(manager, client1, client2, client3);

        List<Client> list =
                manager.createQuery("SELECT c FROM Client c", Client.class).getResultList();
        list.stream().forEach(System.out::println);

        Client res = find(manager, list.get(1).getId());
        System.out.println("Find " + res);

        Client forUpdate = list.get(list.size() - 1);
        forUpdate.setName("Updated");
        update(manager, forUpdate);

        delete(manager, list.get(0));

        manager.close();
        entityManagerFactory.close();
    }

    //create
    private static void persist(EntityManager manager, Client... clients) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            for (Client client : clients) {
                manager.persist(client);
            }
            transaction.commit();
        } catch (Throwable th) {
            th.printStackTrace();
            transaction.rollback();
        }
    }

    //read
    private static Client find(EntityManager manager, Object id) {
        return manager.find(Client.class, id);
    }

    //update
    private static void update(EntityManager manager, Client client) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.merge(client);
            transaction.commit();
        } catch (Throwable th) {
            th.printStackTrace();
            transaction.rollback();
        }
    }

    //delete
    private static void delete(EntityManager manager, Client... clients) {
        EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            for (Client client : clients) {
                manager.remove(client);
            }
            transaction.commit();
        } catch (Throwable th) {
            th.printStackTrace();
            transaction.rollback();
        }
    }
}


