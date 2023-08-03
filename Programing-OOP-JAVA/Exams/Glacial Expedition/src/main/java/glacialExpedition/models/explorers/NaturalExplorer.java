package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{
    public NaturalExplorer(String name) {

        super(name, 60);
    }

    @Override
    public void search() {
        if (this.getEnergy() <= 7) {
            this.setEnergy(0);
        } this.setEnergy(getEnergy() - 7);
    }
}
