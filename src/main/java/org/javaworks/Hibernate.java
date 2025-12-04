package org.javaworks;

import org.hibernate.cfg.Configuration;
import org.javaworks.Entity.Student;
import org.hibernate.*;



public class Hibernate {
    /*
    Hibernate is an Object-Relational Mapping(ORM) solution for Java
    Hibernate maps Java classes to database tables and from Java data types to SQL data types
    ORM means:
    ➡ Convert Java Objects ↔ Database Tables
    ➡ No need to write SQL (or very little)
    ➡ Hibernate takes care of CRUD operations
    ➡ You work with Java classes instead of SQL queries
    | Without Hibernate                    | With Hibernate                  |
    | ------------------------------------ | ------------------------------- |
    | Write SQL INSERT / UPDATE manually   | Use `session.save(student)`     |
    | Convert ResultSet → Objects manually | Hibernate does it automatically |
    | Handle transactions manually         | Hibernate manages it            |
    | DB changes require rewriting SQL     | Hibernate auto-updates schema   |
    | Database dependent                   | DB-independent                  |

    Configuration Object: The Configuration object is the first Hibernate object you create in any Hibernate application. It is usually created only once during application initialization
    SessionFactory Object: SessionFactory object configures Hibernate for the application using the supplied configuration file and allows for a Session object to be instantiated.
    Session Object: A Session is used to get a physical connection with a database. The Session object is lightweight and designed to be instantiated each time an interaction is needed with the database.
    Transaction Object: A Transaction represents a unit of work with the database and most of the RDBMS supports transaction functionality. Transactions in Hibernate are handled by an underlying transaction manager and transaction
    Entity: Java class mapped to a database table is annotated with @Entity
     */
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            //CREATE
            Student student = new Student("Ajith","Akuthota",26);
            session.persist(student);
            // READ
            Student s2 = new Student("Ram","Pothineni",35);
            System.out.println("Student: " + s2.getFirstName() + " " + s2.getLastName());

            //UPDATE
            s2.setAge(30);
            session.merge(s2);
            System.out.println("Student age: " +s2.getAge());



            transaction.commit();
            session.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
