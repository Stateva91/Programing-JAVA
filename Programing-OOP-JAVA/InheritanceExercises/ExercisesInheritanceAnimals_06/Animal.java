package ExercisesInheritanceAnimals_06;

public class Animal {

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        checkInputData(gender);
        this.gender = gender;
    }

    private static void checkInputData(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid input!");
        }
    }

    public String produceSound(){
        return "";
    }

    @Override
    public String toString() {
    return this.getClass().getSimpleName() +System.lineSeparator()
            + this.getName() + " " + this.getAge() + " " + this.getGender() + System.lineSeparator()
            + this.produceSound();
    }
}
