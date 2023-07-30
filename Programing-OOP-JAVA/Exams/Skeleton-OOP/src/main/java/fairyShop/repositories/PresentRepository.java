package fairyShop.repositories;

import fairyShop.models.Present;

import java.util.ArrayList;
import java.util.Collection;

public class PresentRepository<T> implements Repository<Present>{

  private Collection<Present> presents;

    public PresentRepository() {
        this.presents = new ArrayList<>();
    }

    @Override
    public Collection<Present> getModels() {
        return this.presents;
    }

    @Override
    public void add(Present present) {
          this.presents.add(present);
    }

    @Override
    public boolean remove(Present present) {
        return presents.remove(present);
    }

    @Override
    public Present findByName(String name) {
        return this.presents.stream()
                .filter(t -> t.getClass().getSimpleName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
