package ru.eltex.app.java.outputfile;


import ru.eltex.app.java.shop.Order;
import ru.eltex.app.java.shop.Orders;

import java.util.UUID;

public interface IOrder {
    Order readById (UUID uuid);
    void saveById(UUID uuid, Orders<Order> ord);
    Orders<Order> readAll();
    void saveAll(Orders<Order> ord);
}
