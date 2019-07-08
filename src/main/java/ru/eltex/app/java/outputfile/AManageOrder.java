package ru.eltex.app.java.outputfile;

import ru.eltex.app.java.shop.Order;
import ru.eltex.app.java.shop.Orders;

public abstract class AManageOrder implements IOrder {

    Orders<Order> orders;
    Order order;

    public AManageOrder() {
        orders=new Orders<Order>();
    }
}
