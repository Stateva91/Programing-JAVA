package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static glacialExpedition.common.ConstantMessages.*;
import static glacialExpedition.common.ExceptionMessages.*;


public class ControllerImpl implements Controller {

    private Repository<Explorer> explorerRepository;
    private Repository<State> stateStateRepository;
    private MissionImpl mission;

    private int count;
    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateStateRepository=new StateRepository();

    }

    @Override
    public String addExplorer(String type, String explorerName) {

        Explorer explorer;
        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
               explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        this.explorerRepository.add(explorer);

        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {

        State state = new StateImpl(stateName);

        for (String exhibit : exhibits) {
            state.getExhibits().add(exhibit);
            stateStateRepository.add(state);
        }
        return String.format(STATE_ADDED, stateName);
    }
    @Override
    public String retireExplorer(String explorerName) {

      Explorer explorer = this.explorerRepository.byName(explorerName);
        if(explorer==null){
            String msg =String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName);
            throw new IllegalArgumentException(msg);
        }
        this.explorerRepository.remove(explorer);
        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        int retiredCount = 0;

        mission = new MissionImpl();

        List<Explorer> explorersOnMission = this.explorerRepository.getCollection().stream()
                .filter(explorer -> explorer.getEnergy() > 50).collect(Collectors.toList());

        if (explorersOnMission.isEmpty()) {
            throw new IllegalArgumentException(STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        mission.explore(this.stateStateRepository.byName(stateName), explorersOnMission);

        for (Explorer explorer : explorersOnMission) {
            if (explorer.getEnergy() == 0) {
                retiredCount++;
            }
        }

        count++;

        return String.format(STATE_EXPLORER, stateName, retiredCount);
    }

    @Override
    public String finalResult() {

        StringBuilder message = new StringBuilder();

        message.append(String.format(FINAL_STATE_EXPLORED, count)).append(System.lineSeparator());
        message.append(FINAL_EXPLORER_INFO).append(System.lineSeparator());

        for (Explorer explorer : explorerRepository.getCollection()) {
            message.append(String.format(FINAL_EXPLORER_NAME, explorer.getName())).append(System.lineSeparator());
            message.append(String.format(FINAL_EXPLORER_ENERGY, explorer.getEnergy())).append(System.lineSeparator());
            if (explorer.getSuitcase().getExhibits().isEmpty()) {
                message.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS, "None")).append(System.lineSeparator());
            } else {
                message.append(String.format(FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        String.join(FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER,
                                explorer.getSuitcase().getExhibits()))).append(System.lineSeparator());
            }
        }
        return message.toString().trim();
    }
    }

