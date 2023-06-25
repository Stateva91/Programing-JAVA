package EncapsulationAnimalFarm_02;

public class Chicken {
    private String name; //dulzhinata na imeto >=1
    private int age;// [0;15]

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name.length() >= 1) {
            this.name = name;
        }else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    private void setAge(int age) {
        if(age>=0 && age<=15) {
            this.age = age;
        }else {
            throw  new IllegalArgumentException("Age should be between 0 and 15.");
        }
    }
    public double productPerDay (){
       return this.calculateProductPerDay();
    }

    @Override
    public String toString() {
        //Chicken Choko (age 6) can produce 1.00 eggs per day.
        return String.format("Chicken %s %d can produce %.2f eggs per day.", this.name, this.age, this.productPerDay());
    }
    private double calculateProductPerDay(){
      if(this.age>=0 && this.age<=5){
          return 2;
      } else if(this.age>= 6 && this.age<=11){
          return  1;
      }else{
          return  0.75;
      }
    }
}
