package robotService.entities.services;

import robotService.common.ConstantMessages;
import robotService.common.ExceptionMessages;
import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseService implements Service{

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    public BaseService(String name, int capacity) {
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
        this.capacity = capacity;
        this.supplements=new ArrayList<>();
        this.robots=new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Collection<Robot> getRobots() {
        return this.robots;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public void addRobot(Robot robot) {
        if (this.robots.size() == this.capacity){
            throw new IllegalArgumentException(ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }
        this.robots.add(robot);

    }

    @Override
    public void removeRobot(Robot robot) {
    this.robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.getSupplements().add(supplement);
    }

    @Override
    public void feeding() {
        for (Robot robot : this.getRobots()) {
            robot.eating();
        }
    }

    @Override
    public int sumHardness() {
        int sum = 0;

        for (Supplement supplement : this.getSupplements()) {
            sum += supplement.getHardness();
        }

        return sum;
    }

    @Override
    public String getStatistics() {
       return String.format("%s %s:%n", this.name, this.getClass().getSimpleName())
                + String.format("Robots: %s%n", getRobots().isEmpty()
                ? "none"
                : this.getRobots().stream().map(Robot::getName).collect(Collectors.joining(" ")).trim())
                + String.format("Supplements: %s Hardness: %s%n", this.getSupplements().size(), this.sumHardness());
    }
}
