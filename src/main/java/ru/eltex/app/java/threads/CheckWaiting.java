package ru.eltex.app.java.threads;
import ru.eltex.app.java.Main;

import static java.lang.Thread.sleep;

public class CheckWaiting extends ACheck {
    @Override
    public void run() {
        orders= Main.getAllOrders();
        while (!fstop&&orders!=null){
            orders.checkOrders();
            Main.setAllOrders(orders);
            try {
                sleep(500);
            } catch (Exception e) {}
        }
    }
}
