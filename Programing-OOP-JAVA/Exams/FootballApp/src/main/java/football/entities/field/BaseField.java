package football.entities.field;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;

public abstract class BaseField implements Field{

    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;


    public BaseField(String name, int capacity) {
        setName(name);
       setCapacity(capacity);
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int sumEnergy() {
        int sum = 0;
        for (Supplement supplement : supplements) {
            sum += supplement.getEnergy();
        }
        return sum;
    }

    @Override
    public void addPlayer(Player player) {
        if((player.getKg() >= capacity)){
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.players.add(player);

    }

    @Override
    public void removePlayer(Player player) {
       players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
          supplements.add(supplement);
    }

    @Override
    public void drag() {
        for (Player player : this.getPlayers()) {
            player.stimulation();
        }

    }

    @Override
    public String getInfo() {
     StringBuilder output = new StringBuilder();
     output.append(String.format("%s (%s):", this.name,  this.getClass().getSimpleName() )).append(System.lineSeparator());
        if (this.players.isEmpty()) {
            output.append("none");
        }else {

            output.append(this.players.stream().map(Player::getName).collect(Collectors.joining(" ")));
        }
   output.append(String.format("Supplement: %s", supplements)).append(System.lineSeparator());
   output.append(String.format("Energy: %s", sumEnergy())).append(System.lineSeparator());

   return output.toString().trim();


    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
