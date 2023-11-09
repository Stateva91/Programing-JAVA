import entities.Bike;
import entities.Car;
import entities.Plane;
import entities.Vehicle;
import hasEntities.Article;
import hasEntities.PlateNumber;
import hasEntities.Truck;
import hasEntities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("relations");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();

//        Vehicle car= new Car("Ford Focus", "Petrol", 5);
//        Vehicle bike= new Bike();
//        Vehicle plane=new Plane("Airbus", "Petrol", 200);
//
//       entityManager.persist(car);
//       entityManager.persist(bike);
//       entityManager.persist(plane);
//
//        PlateNumber number=new PlateNumber("123");
//        Truck truck=new Truck(number);
//        Truck truck2=new Truck(number);
//
//        entityManager.persist(number);
//        entityManager.persist(truck);
//        entityManager.persist(truck2);

        Article article= new Article("ala");
        User author=new User("Toshko");

        author.addArticle(article);
        article.setAuthor(author);

        entityManager.persist(author);
        entityManager.find(User.class, 2);

      entityManager.getTransaction().commit();
        entityManager.close();
    }
}
