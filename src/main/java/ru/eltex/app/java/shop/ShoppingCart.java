package ru.eltex.app.java.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import ru.eltex.app.java.products.Electronics;

import java.io.Serializable;
import java.util.*;

@JsonAutoDetect
public class ShoppingCart<T extends Electronics>  implements Serializable {


    private List<T> basket;
    private Set<UUID> id;

    public ShoppingCart() {
        basket = new LinkedList<T>();
        id = new HashSet<UUID>();//Вернуть
    }

    public void add(T electronics) {
        basket.add(electronics);
        id.add(electronics.getId());
    }

    public List<T> getShoppingCart() {
        return basket;
    }

    public void delete(T electronics) {
        basket.remove(electronics);
        id.remove(electronics.getId());
    }

    public boolean findById(UUID uuid) {
        return id.contains(uuid);
    }

    public void showAll() {
        for (T it : basket) {
            it.read();
        }
    }
    public List<T> getBasket() {
        return basket;
    }

    public void setBasket(List<T> basket) {
        this.basket = basket;
    }

    public Set<UUID> getId() {
        return id;
    }

    public void setId(Set<UUID> id) {
        this.id = id;
    }
}
