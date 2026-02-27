package com.masood.springjpahibernate.m_3;

import com.masood.springjpahibernate.m_3.entities.Employee;
import com.masood.springjpahibernate.persistence.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;


// em.persist() -> Adding an entity in context
// em.find()    -> Find by PK. Get from DB and add it to the context if not already.
// em.remove()  -> Marking entity for removal.
// em.merge()   -> Merges an entity from outside the context to the context.
// em.refresh() -> Mirror the context from the database.
// em.detach()  -> Taking entity out of the context.
// em.getReference()

public class HibernateClass {



    public  static void main(String[] args) {

        String puName = "oraclePU";
        String password = "";



        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("oraclePU");
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName,password), new HashMap<>());


        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();


            Employee ee = em.find(Employee.class,1);
            ee.setAddress("Cite International225");

            System.out.println(ee.toString());

            em.getTransaction().commit();

           // System.out.println("hello world");

        }
        finally {
            em.close();
        }

    }

}
