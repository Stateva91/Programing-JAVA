import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAMain {
    public static  void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("school-db");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = new Student("Maik");
        em.persist(student);
        Student found = em.find(Student.class, 3);

        System.out.println(found.getId() + " " + found.getName());

//        entityManager.remove(found);

        em.getTransaction().commit();
        em.close();
    }
}
