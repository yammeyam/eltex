package ru.eltex.app.java.shop;

import ru.eltex.app.java.enums.Status;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Random;
import java.util.UUID;


public class Order implements Serializable {
    private long wait;
    private Status status;//Статус заказа
    private Date timeCreate;//Время создания
    private UUID uuid;
    private Date timeWait;//Время ожидания
    private Credentials credentials;
    private ShoppingCart shoppingCart;
    private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd  hh:mm");//Возможно это надо сунуть кула-то еще
    Random random = new Random();

    public UUID getUuid() {
        return uuid;
    }
    public Order(Credentials credentials, ShoppingCart shoppingCart) {
        uuid=UUID.randomUUID();
        this.credentials=credentials;
        this.shoppingCart=shoppingCart;
        status=Status.WAITING;
        timeCreate=new Date(System.currentTimeMillis());
        wait=random.nextLong();
        timeWait=new Date(timeCreate.getTime()+wait);
    }


    public void remakeOrder(Credentials credentials,ShoppingCart shoppingCart){
        this.credentials=credentials;
        this.shoppingCart=shoppingCart;
        timeCreate=new Date(System.currentTimeMillis());
        status=Status.WAITING;
        wait=random.nextLong();//Возсожно косяк
        timeWait=new Date(timeCreate.getTime()+wait);
    }
    public void printOrder(){
        System.out.println("Пользователь:");
        credentials.printCred();
        System.out.println("Товары");
        shoppingCart.showAll();//Вернуть
        System.out.println("\nСтатус заказа: "+status);
        System.out.println("Время создания: "+dateFormat.format(timeCreate)+"\n");
    }
    public Status getStatus() {
        setStatus();
        return status;
    }
    public void setStatus() {
        if (timeWait.getTime()>=System.currentTimeMillis()){
            status=Status.PROCESSED;
        }
    }

    public Date getTimeCreate() {
        return timeCreate;
    }
}
