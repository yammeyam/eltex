package ru.eltex.app.java.threads;



import ru.eltex.app.java.Main;
import ru.eltex.app.java.products.Phone;
import ru.eltex.app.java.products.SmartPhone;
import ru.eltex.app.java.products.Tablet;
import ru.eltex.app.java.shop.Credentials;
import ru.eltex.app.java.shop.ShoppingCart;

import static java.lang.Thread.sleep;

public class Generator extends ACheck {
    private int max;
    private int type;

    @Override
    public void run() {
        while (!fstop) {
            try {
                sleep((int) (Math.random() * 1000)); // Задержка в 0.5 сек
            } catch (Exception e) {
            }
            orders=Main.getAllOrders();
            ShoppingCart current = new ShoppingCart();
            max = 1+(int) Math.random() * 4;
            type = (int) Math.random() * 3;
            for (int i = 0; i < max; i++) {
                switch (type) {
                    case 0:
                        current.add(new Phone(true));
                        break;
                    case 1:
                        current.add(new Tablet(true));
                        break;
                    default:
                        current.add(new SmartPhone(true));
                        break;
                }
            }
            System.out.println("Создал");
            orders.checkout(new Credentials(), current);
            Main.setAllOrders(orders);
            //orders.showAllOrders();
        }
    }
}
