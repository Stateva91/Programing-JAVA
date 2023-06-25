package EncapsulationShoppingSpree_03;

import java.util.ArrayList;
import java.util.List;

public class Person {

  private String  name;

private  double money;

private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products=new ArrayList<>();
    }

    private void setName(String name) {
        if(!name.trim().isEmpty()){
        this.name = name;
        }else {
            throw  new IllegalArgumentException("Name cannot be empty");
        }

    }

    private void setMoney(double money) {
        if(money>=0) {
            this.money = money;
        }else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public void  buyProduct (Product product){
        //proverka dali imam pari za produkta
        //1. ako imam pari->dobavqme produkta v spisuka s produkti
        //2. ako nqma pari->ne go kupuva -> exception->"{Person name} can't afford {Product name}"
      if(this.money>=product.getCost()){
          this.products.add(product);
          this.money-= product.getCost(); // s kolko pari ostavam
      }else {
          String message= this.name+" can't afford " + product.getName();
          throw new IllegalArgumentException(message);
      }
    }

    public String getName() {
        return name;
    }
}
