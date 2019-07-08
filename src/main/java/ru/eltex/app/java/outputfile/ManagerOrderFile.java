package ru.eltex.app.java.outputfile;

import ru.eltex.app.java.shop.Order;
import ru.eltex.app.java.shop.Orders;

import java.io.*;
import java.util.UUID;

public class ManagerOrderFile extends AManageOrder {
    private FileOutputStream fileOutputStream;
    private FileInputStream fileInputStream;
    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    public ManagerOrderFile() {
        try{
            fileOutputStream=new FileOutputStream("temp.bin");
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
            fileInputStream=new FileInputStream("temp.bin");
            objectInputStream=new ObjectInputStream(fileInputStream);
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Order readById(UUID uuid) {
        try {
            orders=(Orders)objectInputStream.readObject();
            if (orders!=null) {
                return orders.getOrderById(uuid);
            }
        }
        catch (IOException e){
            System.err.println(e);
        }
        catch (ClassNotFoundException e){
            System.err.println(e);
        }
        return null;
    }

    @Override
    public void saveById(UUID uuid, Orders<Order> ord){
        try {
            orders.clearAll();
            order=ord.getOrderById(uuid);
            if (order!=null){
                orders.add(order);
            }
            objectOutputStream.writeObject(orders);
            objectOutputStream.flush();
        }
        catch (IOException e){
            System.err.println(e);
        }
    }

    @Override
    public Orders<Order> readAll() {
        try {
            return (Orders)objectInputStream.readObject();
        }
        catch(IOException e){
            System.err.println(e);
        }

        catch (ClassNotFoundException e){
            System.err.println(e);
        }
            return null;
    }

    @Override
    public void saveAll(Orders<Order> ord) {
        try {
            orders=ord;
            objectOutputStream.writeObject(orders);
            objectOutputStream.flush();
            System.out.println("Вывели в файл");
        }
        catch (IOException e){
            System.err.println(e);
        }

    }
}