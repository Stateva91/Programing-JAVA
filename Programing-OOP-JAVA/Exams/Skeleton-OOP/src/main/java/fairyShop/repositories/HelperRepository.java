package fairyShop.repositories;

import fairyShop.models.BaseHelper;
import fairyShop.models.Helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class HelperRepository<T> implements Repository<Helper> {

    private List<Helper> helpers;

    public HelperRepository() {
        this.helpers = new ArrayList<>();
    }


    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableList(this.helpers);
    }

    @Override
    public void add(Helper helper) {
      helpers.add(helper);
    }

    @Override
    public boolean remove(Helper helper) {
        return helpers.remove(helper);
    }

    @Override
    public Helper findByName(String name) {
        return this.helpers.stream()
                .filter(t -> t.getClass().getSimpleName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
