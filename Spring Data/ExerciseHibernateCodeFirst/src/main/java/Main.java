import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory main =
                Persistence.createEntityManagerFactory("main");
        EntityManager entityManager = main.createEntityManager();

    }
}
