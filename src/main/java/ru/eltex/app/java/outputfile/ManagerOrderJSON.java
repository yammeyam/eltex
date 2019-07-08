package ru.eltex.app.java.outputfile;
import ru.eltex.app.java.shop.Order;
import ru.eltex.app.java.shop.Orders;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ManagerOrderJSON extends AManageOrder {
    ObjectMapper mapper;
    File file=new File("temp.json");
    public ManagerOrderJSON() {
        mapper = new ObjectMapper();
    }


    @Override
    public Order readById(UUID uuid) {
        try {
            orders=mapper.readValue(file, Orders.class);
            if (orders!=null) {
                return orders.getOrderById(uuid);
            }
        }
        catch (IOException e){
            System.err.println(e);
        }
        return null;
    }

    @Override
    public void saveById(UUID uuid, Orders<Order> ord) {
        try {
            orders.clearAll();
            order=ord.getOrderById(uuid);
            if (order!=null){
                orders.add(order);
            }
            mapper.writeValue(file,orders);
        } catch (com.fasterxml.jackson.core.JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Orders<Order> readAll() {

        try {
            return mapper.readValue(file,Orders.class);
        }
        catch(IOException e){
            System.err.println(e);
        }
        return null;
    }

    @Override
    public void saveAll(Orders<Order> ord) {
        try {
            orders=ord;
            mapper.writeValue(file,orders);
            System.out.println("Вывели в файл");
        }
        catch (IOException e){
            System.err.println(e);
        }

    }
}
