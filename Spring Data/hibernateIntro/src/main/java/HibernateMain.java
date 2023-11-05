import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateMain {
    public static void main(String[] args) {
        Configuration configuration=new Configuration();
        configuration.configure();

        SessionFactory sessionFactory= configuration.buildSessionFactory();
        Session session= sessionFactory.openSession();
        session.beginTransaction();

//        Student example=new Student();
//        example.setName("Tho");
//        session.persist(example);

//        Student fromDb= session.get(Student.class, 1);
//        System.out.println(fromDb.getId()+ " " +fromDb.getName());

        List<Student> studentList =
                session.createQuery("FROM entities.Student " ,Student.class).list();
        for (Student student : studentList) {
            System.out.println(student.getId());
        }

        session.getTransaction().commit();
        session.close();
    }
}
