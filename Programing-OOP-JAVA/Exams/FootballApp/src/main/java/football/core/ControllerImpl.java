package football.core;


import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;


import static football.common.ConstantMessages.*;
import static football.common.ExceptionMessages.INVALID_PLAYER_TYPE;
import static football.common.ExceptionMessages.NO_SUPPLEMENT_FOUND;

public class ControllerImpl implements Controller {

    private SupplementRepositoryImpl supplement;
    private Collection<Field> fields;

    public ControllerImpl() {
        this.supplement = new SupplementRepositoryImpl();
        this.fields= new ArrayList<>();
    }

    @Override
    public String addField(String fieldType, String fieldName) {

        Field field;
        switch (fieldType){
            case "ArtificialTurf":
                field=new ArtificialTurf(fieldName);
                break;
            case "NaturalGrass":
                field=new NaturalGrass(fieldName);
                break;
            default:
                throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
        }
        fields.add(field);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);

    }

    @Override
    public String deliverySupplement(String type) {

        Supplement supplement;
        switch (type){
            case "Powdered":
                supplement=new Powdered();
                break;
            case "Liquid":
                supplement=new Liquid();
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
        }
        this.supplement.add(supplement);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForField(String fieldName, String supplementType) {
        Field field = getFieldByName(fieldName);
        Supplement supplements = supplement.findByType(supplementType);
        if (supplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND,supplementType));
        }
        field.addSupplement(supplements);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD,supplementType , fieldName);
    }

    @Override
    public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
        Field field= getFieldByName(fieldName);
        Player player;
        switch (playerType) {
            case "Women":
                player = new Women(playerName, nationality, strength);
                break;
            case "Men":
                player = new Men(playerName, nationality, strength);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PLAYER_TYPE);
        }
        if (field.getClass().getSimpleName().equals("ArtificialTurf") && playerType.equals("Women")) {
            field.addPlayer(player);
        } else if (field.getClass().getSimpleName().equals("NaturalGrass") && playerType.equals("Men")) {
            field.addPlayer(player);;
        } else {
            return FIELD_NOT_SUITABLE;
        }
        return String.format(SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
    }
    private Field getFieldByName(String fieldName) {
        return fields.stream()
                .filter(f -> f.getName().equals(fieldName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String dragPlayer(String fieldName) {

        Field field = getFieldByName(fieldName);
        for (Player p : field.getPlayers()) {
            p.stimulation();
        }
        return String.format(PLAYER_DRAG, field.getPlayers().size());
    }

    @Override
    public String calculateStrength(String fieldName) {
        Field field = getFieldByName(fieldName);
        int sumStrength = 0;
        for (Player p : field.getPlayers()) {
            sumStrength += p.getStrength();
        }

        return String.format(STRENGTH_FIELD, fieldName, sumStrength);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb=new StringBuilder();
        for (Field field : this.fields) {
            sb.append(field.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
