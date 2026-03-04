package com.masood.springjpahibernate.m_5;


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
// em.getReference() -> query is generated when you do something with the object, like the lazy initialization in kotlin

public class HibernateClass {



    public  static void main(String[] args) {

        String puName = "oraclePU";
        String password = "#";

        HashMap<String,String> props = new HashMap<>();
        props.put("hibernate.show_sql","true");
        props.put("hibernate.hbm2ddl.auto","create"); //(create tables automatically) //always use with examples and tutorials. none -> production, create -> drop then create, update -> update tables only.

        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("oraclePU");
        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName,password), props);


        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();


            em.getTransaction().commit();


        }
        finally {
            em.close();
        }

    }

}
