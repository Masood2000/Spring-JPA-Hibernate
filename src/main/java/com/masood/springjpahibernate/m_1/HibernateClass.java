package com.masood.springjpahibernate.m_1;

import com.masood.springjpahibernate.m_1.entities.Product;
import com.masood.springjpahibernate.persistence.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

public class HibernateClass {



    public  static void main(String[] args) {

        String puName = "oraclePU";
        String password = "######";


        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("oraclePU");
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName,password), new HashMap<>());


        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();


            Product pp = em.find(Product.class,1);

            System.out.println(pp);

            em.getTransaction().commit();

           // System.out.println("hello world");

        }
        finally {
            em.close();
        }

    }

}
