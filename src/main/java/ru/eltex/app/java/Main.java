package ru.eltex.app.java;

import ru.eltex.app.java.outputfile.ManagerOrderJSON;
import ru.eltex.app.java.threads.CheckWaiting;
import ru.eltex.app.java.threads.DelOld;
import ru.eltex.app.java.threads.Generator;
import ru.eltex.app.java.shop.Orders;

import java.util.UUID;

import static java.lang.Thread.sleep;

public class Main {
    private static Orders allOrders=new Orders();
    public static synchronized Orders getAllOrders() {
        return Main.allOrders;
    }

    public static synchronized void setAllOrders(Orders allOrders) {
        Main.allOrders = allOrders;
    }

    public static void main(String[] args)  {
      //args[0]-кол-во вводимых объектов

        //args[1]-вид представления
       /* int countInput =0;
        try{
            countInput = Integer.parseInt(args[0]);//кол-во объектов
        }catch (NumberFormatException e){
            System.out.println("Неверные параметры");
            System.exit(0);
        }
        ArrayList<Electronics> input=new ArrayList<>();
        while (countInput>0){//Создание заданных объектов
            switch (args[1]){
                case "TABLET": input.add(new Tablet()); break;
                case "MOBILEPHONE": input.add(new Phone()); break;
                case "SMARTPHONE": input.add(new SmartPhone()); break;
            }
            countInput--;
        }
        Main main=new Main();
*/
        Generator g1 = new Generator();
        Generator g2 = new Generator();
        CheckWaiting check =new CheckWaiting();
        DelOld d=new DelOld();
        Thread gen1= new Thread(g1);
        Thread gen2= new Thread(g2);
        Thread checkW=new Thread(check);
        Thread del = new Thread(d);
        gen1.start();
        gen2.start();
        checkW.start();
        del.start();
        //Main.getAllOrders().showAllOrders();

        try{
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        d.finish();
        g2.finish();
        check.finish();
        g1.finish();
        try{
            Thread.sleep(500);
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        /*ManagerOrderFile managerOrderFile=new ManagerOrderFile();
        managerOrderFile.saveAll(allOrders);
        System.out.println("-----------------");
        allOrders.clearAll();
        allOrders.showAllOrders();
        System.out.println("-----------------");
        allOrders=managerOrderFile.readAll();
        allOrders.showAllOrders();
        System.out.println("-----------------");
        UUID cur=allOrders.getFirstUUID();
        managerOrderFile.saveById(cur,allOrders);
        allOrders.add(managerOrderFile.readById(cur));
        allOrders.showAllOrders();
        System.out.println("-----------------");*/
        ManagerOrderJSON managerOrderJSON=new ManagerOrderJSON();
        managerOrderJSON.saveAll(allOrders);
        System.out.println("-----------------");
        allOrders.clearAll();
        allOrders.showAllOrders();
        System.out.println("-----------------");
        allOrders=managerOrderJSON.readAll();
        allOrders.showAllOrders();
        System.out.println("-----------------");
        UUID cur=allOrders.getFirstUUID();
        managerOrderJSON.saveById(cur,allOrders);
        allOrders.add(managerOrderJSON.readById(cur));
        allOrders.showAllOrders();
        System.out.println("-----------------");
    }
}

