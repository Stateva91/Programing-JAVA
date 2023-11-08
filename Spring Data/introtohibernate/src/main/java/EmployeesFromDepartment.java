import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeesFromDepartment {
    private static  final String PRINT_EMP_FORMAT="%s %s from %s - $%2.f%n";
    public static void main(String[] args) {

      final EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("soft_uni");
      final  EntityManager entityManager= entityManagerFactory.createEntityManager();
      final String department="Research and Development";

      entityManager.createQuery("SELECT e FROM Employee e " +
                      "WHERE e.department.name = :dp " +
                      "ORDER BY e.salary asc, e.id", Employee.class)
              .setParameter("dp", department)
              .getResultList()
              .forEach(e-> System.out.printf(PRINT_EMP_FORMAT,
                    e.getFirstName(),
                    e.getLastName(),
                    e.getDepartment(),
                    e.getSalary()));

      entityManager.getTransaction().commit();
      entityManager.close();
    }
}
