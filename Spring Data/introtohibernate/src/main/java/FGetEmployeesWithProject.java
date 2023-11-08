import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class FGetEmployeesWithProject {
    public static void main(String[] args) {
        final EntityManager entityManager = Persistence.createEntityManagerFactory("soft_uni")
                .createEntityManager();
        final int empId=new Scanner(System.in).nextInt();

        System.out.println(entityManager.createQuery("SELECT e FROM Employee e WHERE e.id = :id", Employee.class)
               .setParameter("id", empId)
               .getSingleResult()
               .toString());


    }
}
