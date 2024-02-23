import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
      //  EmployeesFromDepartment_5(entityManager);
        AddingANewAddressAndUpdatingEmployee_6(entityManager);
       entityManager.getTransaction().commit();
    }

    private static void AddingANewAddressAndUpdatingEmployee_6(EntityManager entityManager) throws IOException {
       Town town=entityManager.find(Town.class, 32);
        Address address=new Address();
        address.setText("Vitoshka 15");
        address.setTown(town);

        entityManager.persist(address);
        String lastName= READER.readLine();
        List<Employee> resultList=entityManager.createQuery("FROM Employee WHERE lastName= :lastName", Employee.class)
                .setParameter("lastName", lastName)
                .getResultList();
        if (!resultList.isEmpty()){
            Employee employee= resultList.get(0);
            employee.setAddress(address);
            entityManager.persist(employee);
        }
    }

    private static void EmployeesFromDepartment_5(EntityManager entityManager) {
   entityManager.createQuery("SELECT e FROM Employee e JOIN e.department d WHERE d.id=6 ORDER BY e.salary, e.id", Employee.class)
           .getResultStream()
           .forEach(e-> System.out.printf("%s %s from Research and Development - $%.2f%n",
                   e.getFirstName(), e.getLastName(), e.getSalary()));

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