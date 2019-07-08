package ru.eltex.app.java.threads;

import ru.eltex.app.java.shop.Order;
import ru.eltex.app.java.shop.Orders;

public abstract class ACheck implements Runnable{
    protected Orders orders;

    public ACheck() {
        orders = new Orders<Order>();
    }

    boolean fstop=false;
    public void finish(){
        fstop=true;
    }
}
