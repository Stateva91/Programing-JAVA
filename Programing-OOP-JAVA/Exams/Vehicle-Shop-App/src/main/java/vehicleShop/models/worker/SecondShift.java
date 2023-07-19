package vehicleShop.models.worker;

public class SecondShift extends BaseWorker {
    public SecondShift(String name) {
        super(name, 70);
    }

    @Override
    public void working() {

        super.setStrength(Math.max(super.getStrength() - 5, 0));
    }
}