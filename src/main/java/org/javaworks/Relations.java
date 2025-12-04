package org.javaworks;

import org.hibernate.cfg.Configuration;
import org.javaworks.Entity.Address;
import org.javaworks.Entity.Course;
import org.javaworks.Entity.Department;
import org.javaworks.Entity.Student;
import org.hibernate.*;

import java.util.ArrayList;
import java.util.List;
/*
    ONE-TO-ONE → Address Entity
    -> A student has one address
    -> An address belongs to one student
    ONE-TO-MANY → Department Entity
    -> One department has many students
    -> A student belongs to one department
    MANY-TO-MANY → Course Entity
    -> A student can take many courses
    -> A course can have many students
| Relationship | Entities              | Table Handling             | FK Location              |
| ------------ | --------------------- | -------------------------- | ------------------------ |
| One-to-One   | Student ↔ Address     | No extra table             | `students.address_id`    |
| One-to-Many  | Department → Students | No extra table             | `students.department_id` |
| Many-to-Many | Student ↔ Courses     | new `student_course` table | Both IDs                 |

What is FetchType?
In Hibernate, fetching determines when related entities are loaded from the database.

| Fetch Type | Meaning                                                      | Default Usage           |
| ---------- | ------------------------------------------------------------ | ----------------------- |
| **EAGER**  | Load **related entity immediately** along with parent entity | @OneToOne, @ManyToOne   |
| **LAZY**   | Load **related entity only when accessed** (on demand)       | @OneToMany, @ManyToMany |

Why FetchType Matters?
Performance:
Loading too many entities at once can slow down the app.
Memory:
Loading only when needed reduces memory usage.
Control:
Decide whether you want data upfront (EAGER) or on demand (LAZY).
 */


public class Relations {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            //CREATE
            Student student = new Student("Ajith","Akuthota",26);
            Address address=new Address("Hammons","Saint Louis","Missouri","63108");

            Department department=new Department("Computer Science");
            Department department1=new Department(" AI");

            List<Course> courses=new ArrayList<>();
            Course c1 = new Course("Java");
            Course c2 = new Course("Database Systems");
            courses.add(c1);
            courses.add(c2);

            student.setCourses(courses);
            student.setAddress(address);

            Student s2=new Student("Ram","Pothineni",35);
            Student s3=new Student("Mahesh","Babu",45);
            student.setDepartment(department);

            s2.setDepartment(department1);
            s3.setDepartment(department1);



            session.persist(student);
            session.persist(s2);
            session.persist(s3);

            transaction.commit();
            session.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
