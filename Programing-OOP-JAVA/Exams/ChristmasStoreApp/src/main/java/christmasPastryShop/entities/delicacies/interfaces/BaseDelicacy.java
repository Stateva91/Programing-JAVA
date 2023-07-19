package christmasPastryShop.entities.delicacies.interfaces;

import christmasPastryShop.common.ExceptionMessages;

public abstract class BaseDelicacy implements Delicacy{
    private String name;
    private double portion;
    private double price;

    public BaseDelicacy(String name, double portion, double price) {
        setName(name);
        setPortion(portion);
        setPrice(price);
    }

    public void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_NAME);
        }
        this.name = name;
    }

    public void setPortion(double portion) {
        if(portion<=0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PORTION);
        }
        this.portion = portion;
    }

    public void setPrice(double price) {
        if(price<=0){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_PRICE);
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        //"{current delicacy name}: {current portion - formatted to the second digit}g - {current price - formatted to the second digit}"
        return String.format("%s: %.2fg - %.2f%n", this.name, this.portion, this.price);
    }
}
