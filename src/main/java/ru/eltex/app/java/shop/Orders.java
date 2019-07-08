package ru.eltex.app.java.shop;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ru.eltex.app.java.enums.Status;

import java.io.Serializable;
import java.sql.Date;
import java.util.*;

public class Orders <T extends Order > implements Serializable {
    public Orders() {
        orders = new ArrayList<T>();
        sortBasket = new TreeMap<Date,T>();
    }

    private List<T> orders;

    public List<T> getOrders() {
        return orders;
    }

    private Map<Date, T> sortBasket;

    public void checkout(Credentials credentials, ShoppingCart shoppingCart) {
        synchronized (orders) {
            T current = (T) new Order(credentials, shoppingCart);
            synchronized (orders) {
                orders.add(current);
                sortBasket.put(current.getTimeCreate(), current);
            }
        }
    }
    public void add(T order){
        synchronized (orders) {
            orders.add(order);
            sortBasket.put(order.getTimeCreate(), order);
        }
    }
    public void checkOrders() {
        synchronized (orders){
            for (T it : orders) {
               it.setStatus();
            }
        }
    }

    public void delOrders() {
        synchronized (orders) {
            for (T it : orders) {
                if (it.getStatus() == Status.PROCESSED) {
                    orders.remove(it);
                    System.out.println("Удалено");
                    it.printOrder();
                    sortBasket.remove(it.getTimeCreate());
                    return;
                }
            }
        }
    }
    public Order getOrderById(UUID uuid){
        for (T it:orders){
            if(it.getUuid()==uuid){
                return it;
            }
        }
        return null;
    }
    public void showAllOrders() {
        System.out.println("Все заказы:");
            for (T it : orders) {
                it.printOrder();
            }
    }
    public void clearAll(){
        synchronized (orders) {
            orders.clear();
            sortBasket.clear();
        }
    }
    public UUID getFirstUUID(){
        for (T current: orders){
           return current.getUuid();
        }
        return null;
    }
}