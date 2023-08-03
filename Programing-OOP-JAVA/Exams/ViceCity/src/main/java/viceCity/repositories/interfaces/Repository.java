package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.Collection;

public interface Repository<T> {
    Collection<T> getModels();

    void add(T model);

    void add(Gun model);

    boolean remove(T model);

    boolean remove(Gun model);

    T find(String name);
}
