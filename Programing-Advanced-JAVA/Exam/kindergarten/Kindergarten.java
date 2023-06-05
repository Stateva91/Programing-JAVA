package kindergarten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Kindergarten {

    private String name;
    private int capacity;
    private List<Child> registry;

    public Kindergarten(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.registry=new ArrayList<>();
    }
    public boolean addChild(Child child){
        if(this.capacity>this.registry.size()){
            this.registry.add(child);
            return true;
        }
        return false;
    }
    public boolean removeChild(String firstName){
        Child child = this.getChild(firstName);
        registry.remove(child);
        return child != null;
    }
    public int getChildrenCount(){
        return this.registry.size();
    }

    public Child getChild(String firstName) {
        return registry.stream()
                .filter(e->e.getFirstName().equals(firstName))
                .findFirst()
                .orElse(null);
    }
    public String registryReport(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Registered children in %s:%n", this.name));
        List<Child> sortedList = new ArrayList<>();
        for (Child c : registry) {
            sortedList.add(c);
        }
        sortedList.sort(Comparator.comparing(Child::getAge)
                .thenComparing(Child::getFirstName)
                .thenComparing(Child::getLastName));


        for (Child child : sortedList) {
            sb.append("--");
            sb.append(System.lineSeparator());
            sb.append(child);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
    }

