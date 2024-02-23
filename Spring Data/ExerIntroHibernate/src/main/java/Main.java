import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    private  static final BufferedReader READER=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("soft_uni");

        EntityManager entityManager= entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
       // ex_3(entityManager);
      // ex_2(entityManager);
      //  EmployeesWithSalaryOver50000_4(entityManager);
        EmployeesFromDepartment_5(entityManager);
       entityManager.getTransaction().commit();
    }

    private static void EmployeesFromDepartment_5(EntityManager entityManager) {
        Query query = entityManager.createQuery("FROM Employee e JOIN e.department d WHERE d.id=6");
        List resultList=query.getResultList();
        System.out.println();
    }

    private static void EmployeesWithSalaryOver50000_4(EntityManager entityManager) {
   entityManager.createQuery("FROM Employee WHERE salary>50000", Employee.class)
           .getResultStream()
           .map(Employee::getFirstName)
           .forEach(System.out::println);

    }


    private static void ex_2(EntityManager entityManager) {
        List<Town> resultList = entityManager.createQuery("FROM Town WHERE LENGTH(name)>5", Town.class).getResultList();

        resultList.forEach(town -> {
            town.setName(town.getName().toUpperCase());
            entityManager.persist(town);
        });


    }

    private static void ex_3(EntityManager entityManager) throws IOException {
        String[] input=READER.readLine().split("\\s+");
        List<Employee> resultList = entityManager.createQuery("FROM Employee WHERE firstName= :first_name AND lastName= :last_name", Employee.class)
                .setParameter("first_name", input[0])
                .setParameter("last_name", input[1])
                .getResultList();

        System.out.println(resultList.size()>0 ? "Yes": "No");
    }
}