package OpinionPoll_01;

public class Person {
    //harakteristiki

    private  String name;
    private int age;

    //konstruktor-chrez nego suzdavame obekti ot klasa
    public  Person (String name, int age){
        this.name=name;
        this.age=age;
    }
    //get-dostup do poleto, vrushta stoinost
    public String getName(){
        return name;
    }
    public  int getAge(){
        return  age;
    }
    @Override
    public String toString(){
        return  name +" - "+age;
    }
}
