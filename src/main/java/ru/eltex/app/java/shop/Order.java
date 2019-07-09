package ru.eltex.app.java.shop;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import ru.eltex.app.java.enums.Status;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Random;
import java.util.UUID;

@JsonAutoDetect
public class Order implements Serializable {
    private long wait;
    private Status status;//Статус заказа
    @JsonFormat
    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }
    @JsonFormat
    public void setTimeWait(Date timeWait) {
        this.timeWait = timeWait;
    }
    @JsonFormat
    public Date getTimeCreate() {
        return timeCreate ;
    }
    @JsonFormat
    public Date getTimeWait() {
        return  timeWait ;
    }
    @JsonFormat
    private Date timeCreate;//Время создания
    private UUID uuid;
    @JsonFormat
    private Date timeWait;//Время ожидания
    private Credentials credentials;
    private ShoppingCart shoppingCart;
    private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy.MM.dd  hh:mm");//Возможно это надо сунуть кула-то еще
    Random random = new Random();

    public UUID getUuid() {
        return uuid;
    }
    public Order(){
        wait=0;
        status=null;
        timeCreate=null;
        uuid=null;
        timeWait=null;
        credentials=null;
        shoppingCart=null;
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

  /*  public Date getTimeCreate() {
        return timeCreate;
    }*/
    public long getWait() {
        return wait;
    }
  /*  public long getTimeCreate() {
        return timeCreate.getTime();
    }

    public void setWait(long wait) {
        this.wait = wait;
    }
*/
    public void setStatus(Status status) {
        this.status = status;
    }

  /*  public void setTimeCreate(long time) {
        timeCreate.setTime(time);
    }*/

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

/*    public long getTimeWait() {
        return timeWait.getTime();
    }

    public void setTimeWait(long time) {
        timeWait.setTime(time);
    }*/

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

}
