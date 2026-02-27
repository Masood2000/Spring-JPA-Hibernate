package com.masood.springjpahibernate.m_2;

import com.masood.springjpahibernate.m_2.entities.Employee;
import com.masood.springjpahibernate.persistence.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;

public class HibernateClass {



    public  static void main(String[] args) {

        String puName = "oraclePU";
        String password = "###########";


        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("oraclePU");
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName,password), new HashMap<>());


        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();


            Employee ee = em.find(Employee.class,1);
            ee.setAddress("Cite International");

            System.out.println(ee.toString());

            em.getTransaction().commit();

           // System.out.println("hello world");

        }
        finally {
            em.close();
        }

    }

}
