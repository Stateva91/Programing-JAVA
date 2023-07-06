package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller{

    private ToyRepository toys; // suvkupnost ot igrachki
    private Collection<House> house; // suvkupnost ot kushti
    public ControllerImpl() {
        this.toys=new ToyRepository();
        this.house=new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        //suzdavame kushtata
        House house=null;
        //type->"ShortHouse" ili "LongHouse"
        if(type.equals("ShortHouse")){
            //kushta ot klas
            house=new ShortHouse(name);
        } else if (type.equals("Longhouse")){
            house=new LongHouse(name);
        } else {
            throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }
        //dobavqme kushata v spisuka s kushti
        this.house.add(house);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        //suzdavame igrachka
        Toy toy;
        if(type.equals("Ball")){
            toy=new Ball();
        }else if (type.equals("Mouse")) {
            toy=new Mouse();
        }else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        //kupuvam igrachkata
        this.toys.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        //vzimam igrachkata ot spisuka s igrachkite
        Toy toy=this.toys.findFirst(toyType);
        if(toy==null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }
        //kupiuvam igrachakta za kushtata
        House house=getHouseByName(houseName);
        house.buyToy(toy);
        // premahvam igrachkata ot toyRepository
        this.toys.removeToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    private House getHouseByName(String houseName) {
        //vrushta kushta ot spisuka po ime
      return   this.house.stream()
                .filter(house-> house.getName().equals(houseName))
                .findFirst().get();
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
       //suzdavam kotka po neiniq tip i ime
        Cat cat;
        switch (catType){
            case "ShorthairCat":
                cat=new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat=new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }
        //namirame kushta s dadenoto ime
        House house=getHouseByName(houseName);
        //dobavqme kotkata v kushtata
        //1. kotkata nemoje da vleze v kushtata
        boolean checkShort=catType.startsWith("Short") && house.getClass().getSimpleName().startsWith("Short");
        boolean checkLong=catType.startsWith("Long") && house.getClass().getSimpleName().startsWith("Long");
        if (checkShort || checkLong) {
            //2. kotkata moje da vleze
            house.addCat(cat);
        } else {
            return  ConstantMessages.UNSUITABLE_HOUSE;
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        //vzima kushtata s ime
        House house=getHouseByName(houseName);
        house.feeding();// preminava prez vsqka edna ot kotkite
        return String.format(ConstantMessages.FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house=getHouseByName(houseName);
        double priceCats=house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double priceToys=house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        double priceAll=priceCats+priceToys;
        return String.format(ConstantMessages.VALUE_HOUSE, houseName, priceAll);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder=new StringBuilder();
       for(House house: this.house){
           builder.append(house.getStatistics()).append(System.lineSeparator());
       }
       return builder.toString().trim();
    }
}
