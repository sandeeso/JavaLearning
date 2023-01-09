package soni.sandeep.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import soni.sandeep.entity.People;

import java.sql.SQLException;
import java.util.prefs.BackingStoreException;

@Service
public class HumanManagerImpl {

    @Autowired
    EntityManagerFactory e;

  /*  @Autowired
    @Qualifier ("employeeManager")
    JpaRepository peopleManager;*/

    @Autowired
    BeanManager beanManager;

    public People finding(int id ) throws SQLException {

       // EntityManager emf = beanManager.entityManagerFactory().createEntityManager();
        // return new People();


       EntityManagerFactory em = getEntityManager();
        Query q = em.createEntityManager().createQuery("select p from People p");
        return (People) q.getSingleResult();

         /*Query q = e.createEntityManager().createQuery("select p from People p");
         return (People) q.getSingleResult();*/

    }

    public void save() throws SQLException {
         People p= new People();
         p.setId(2);
         p.setAge(25);
         p.setName("Rahul");
         p.setDob("12/11/2000");
         p.setProfession("engineer");
        EntityManagerFactory em = getEntityManager();
        em.createEntityManager().merge(p);

    }

    public void savePersist() throws SQLException {
        People p= new People();

        p.setAge(25);
        p.setName("pahul");
        p.setDob("12/11/2000");
        p.setProfession("engineer");
        EntityManager em = getEntityManager().createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

    }

    public EntityManagerFactory getEntityManager() throws SQLException {
        EntityManagerFactory em = beanManager.entityManagerFactory();
        return em;
    }
}
