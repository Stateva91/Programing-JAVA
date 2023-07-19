package vehicleShop.models.worker;

import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.tool.Tool;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseWorker implements Worker{

    private String name;
    private int strength;

    private Collection<Tool>tools;

    public BaseWorker(String name, int strength) {
       setName(name);
        setStrength(strength);
       setTools(tools);
    }

    @Override
    public void working() {

        setStrength(Math.max(getStrength() - 10, 0));

    }

    public void setName(String name) {
        if(name==null || name.equals("")){
            throw new IllegalArgumentException(ExceptionMessages.WORKER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setStrength(int strength) {
        if(strength<0){
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    public void setTools(Collection<Tool> tools) {
        this.tools=new ArrayList<>();
    }

    @Override
    public void addTool(Tool tool) {
       this.tools.add(tool);
    }

    @Override
    public boolean canWork() {

        return getStrength()>0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public Collection<Tool> getTools() {
        return this.tools;
    }
    @Override
    public String toString() {
        long countFitTools = this.getTools().stream().filter(t -> t.getPower()>0).count();
        StringBuilder output = new StringBuilder();
        output.append(String.format("Name: %s, Strength: %d", this.name, this.strength)).append(System.lineSeparator());
        output.append(String.format("Tools: %d fit left", countFitTools)).append(System.lineSeparator());
        return output.toString().trim();
    }
}
