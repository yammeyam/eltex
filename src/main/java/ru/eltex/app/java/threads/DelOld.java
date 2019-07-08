package ru.eltex.app.java.threads;


import ru.eltex.app.java.Main;

import static java.lang.Thread.sleep;

public class DelOld extends ACheck {
    @Override
    public void run() {
        orders=Main.getAllOrders();
        while(!fstop&&orders!=null){
            orders.delOrders();
            Main.setAllOrders(orders);
            try {
                sleep(500); // Задержка в 0.5 сек
            } catch (Exception e) {}
        }
    }
}
