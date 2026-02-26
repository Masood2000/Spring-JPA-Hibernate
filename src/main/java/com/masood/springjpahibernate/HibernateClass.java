package com.masood.springjpahibernate;

import com.masood.springjpahibernate.m_1.entities.Product;
import com.masood.springjpahibernate.persistence.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

public class HibernateClass {



    public  static void main(String[] args) {

        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("oraclePU");
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(), new HashMap<>());


        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Product p = new Product();
            p.setId(3L);
            p.setName("pencil");

            em.persist(p);

            em.getTransaction().commit();

            System.out.println("hello world");

        }
        finally {
            em.close();
        }

    }

}
