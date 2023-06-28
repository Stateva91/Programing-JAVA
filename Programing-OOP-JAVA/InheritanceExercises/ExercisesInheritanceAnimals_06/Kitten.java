package ExercisesInheritanceAnimals_06;

public class Kitten extends Cat {

    private static final String KITTENS_GENDER="Female";

    public Kitten(String name, int age) {
        super(name, age, KITTENS_GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
