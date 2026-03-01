package com.masood.springjpahibernate.m_4;

import com.masood.springjpahibernate.m_4.entities.Employee;
import com.masood.springjpahibernate.m_4.entities.Product;
import com.masood.springjpahibernate.m_4.entities.Student;
import com.masood.springjpahibernate.m_4.entities.keys.StudentKey;
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

            Employee ee = new Employee();

            ee.setName("Masood");
            ee.setAddress("Toulouse, France");


            Product pp = new Product();
            pp.setCode("chod");
            pp.setNum(200l);
            pp.setColor("blue");


            StudentKey sk = new StudentKey();
            sk.setCode("abc");
            sk.setNum(300);

            Student s = new Student();
            s.setId(sk);
            s.setName("masood");



            em.persist(ee);
            em.persist(pp);
            em.persist(s);

            em.getTransaction().commit();

            //refresh
            /*
             Refresh
             var e1 = em.find(Employee.class,1);

             e1.setName("Masood ur Rehman22");

             em.refresh(e1);
             */
            //persist, find
            /*
                        Employee ee = new Employee();
                        ee.setId(1L);
                        ee.setAddress("Ramonville");
                        ee.setName("Masood");

                        em.persist(ee);

                        Employee ee2 = em.find(Employee.class,1);

                        if(ee2 != null ) {
                            ee2.setAddress("Cite International");
                            System.out.println(ee.toString());
                        }
            */

        }
        finally {
            em.close();
        }

    }


}
