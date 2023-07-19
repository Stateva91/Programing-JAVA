package christmasPastryShop.core;

import christmasPastryShop.common.ExceptionMessages;
import christmasPastryShop.common.OutputMessages;
import christmasPastryShop.common.enums.BoothType;
import christmasPastryShop.common.enums.CocktailType;
import christmasPastryShop.common.enums.DelicacyType;
import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.LinkedHashMap;
import java.util.Map;

public class ControllerImpl implements Controller {
    private  DelicacyRepository<Delicacy> delicacyRepository;
    private  CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalIncome;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
        this.totalIncome=0;

    }


//    @Override
//    public String addDelicacy(String type, String name, double price) {
//        Delicacy delicacy;
//        switch (type){
//            case "Stolen":
//                delicacy=new Stolen(name, price);
//                break;
//            case "Gingerbread":
//                delicacy=new Gingerbread(name, price);
//                break;
//            default:
//                throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
//        }
//        delicacyRepository.add(delicacy);
//        return String.format(OutputMessages.DELICACY_ADDED,name, type);
//    }
//
//    @Override
//    public String addCocktail(String type, String name, int portion, String brand) {
//        Cocktail cocktail;
//        switch (type){
//            case "Hibernation":
//                cocktail=new Hibernation(name,portion, brand);
//                break;
//            case "MulledWine":
//                cocktail=new MulledWine(name, portion, brand);
//                break;
//            default:
//                throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
//        }
//        cocktailRepository.add(cocktail);
//        return String.format(OutputMessages.COCKTAIL_ADDED,name, brand);
//    }
//
//    @Override
//    public String addBooth(String type, int boothNumber, int capacity) {
//        Booth booth;
//        switch (type){
//            case "OpenBooth":
//                booth=new OpenBooth(boothNumber, capacity);
//                break;
//            case "PrivateBooth":
//                booth=new PrivateBooth(boothNumber, capacity);
//                break;
//            default:
//                throw new IllegalArgumentException(String.format(ExceptionMessages.BOOTH_EXIST, boothNumber));
//        }
//        boothRepository.add(booth);
//        return String.format(OutputMessages.BOOTH_ADDED,boothNumber);
//    }
@Override
public String addDelicacy(String type, String name, double price) {
    Delicacy delicacy = delicacyRepository.getByName(name);
    if (delicacy == null) {
        DelicacyType foodType = DelicacyType.valueOf(type);
        switch (foodType) {
            case Gingerbread:
                delicacy = new Gingerbread(name, price);
                break;
            case Stolen:
                delicacy = new Stolen(name, price);
                break;
        }
    } else {
        throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, delicacy.getClass().getSimpleName(), name));

    }
    delicacyRepository.add(delicacy);
    return String.format(OutputMessages.DELICACY_ADDED, name, type);
}

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = cocktailRepository.getByName(name);
        if (cocktail == null) {
            CocktailType cocktailType = CocktailType.valueOf(type);

            switch (cocktailType) {
                case MulledWine:
                    cocktail = new MulledWine(name, size, brand);
                    break;
                case Hibernation:
                    cocktail = new Hibernation(name, size, brand);
                    break;
            }
        } else {
            String message = String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, cocktail.getClass().getSimpleName(), cocktail.getName());
            throw new IllegalArgumentException(message);
        }
        cocktailRepository.add(cocktail);
        return String.format(OutputMessages.COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        if (booth == null) {
            BoothType tableType = BoothType.valueOf(type);

            switch (tableType) {
                case OpenBooth:
                    booth = new OpenBooth(boothNumber, capacity);
                    break;
                case PrivateBooth:
                    booth = new PrivateBooth(boothNumber, capacity);
                    break;
            }
        } else {
            String message = String.format(ExceptionMessages.BOOTH_EXIST, boothNumber);
            throw new IllegalArgumentException(message);
        }
        boothRepository.add(booth);
        return String.format(OutputMessages.BOOTH_ADDED, boothNumber);
    }
    @Override
    public String reserveBooth(int numberOfPeople) {
        for (Booth booth : boothRepository.getAll()) {
            if (!booth.isReserved() && booth.getCapacity() >= numberOfPeople) {
                booth.reserve(numberOfPeople);
                return String.format(OutputMessages.BOOTH_RESERVED, booth.getBoothNumber(), numberOfPeople);

            }
        }
        return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        double bill = booth.getBill();
        this.totalIncome += bill;
        booth.clear();
        return String.format(OutputMessages.BILL, boothNumber, bill);
    }
//    @Override
//    public String orderDelicacy(int boothNumber, String delicacyName) {
//        Booth boothFromRepo = boothRepository.getByNumber(boothNumber);
//        Delicacy food = delicacyRepository.getByName(delicacyName);
//        if (boothFromRepo == null || !boothFromRepo.isReserved()) {
//            return String.format(OutputMessages.WRONG_BOOTH_NUMBER, boothNumber);
//        }
//        if (food == null) {
//            return String.format(OutputMessages.NONE_EXISTENT_DELICACY, delicacyName);
//        }
//        boothFromRepo.orderDelicacy(food);
//        return String.format(OutputMessages.BOOTH_ORDER_SUCCESSFUL, boothNumber, delicacyName);
//    }

    @Override
    public String getIncome() {
        return String.format(OutputMessages.TOTAL_INCOME, this.totalIncome);
    }
}
