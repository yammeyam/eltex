package ru.eltex.app.java.products;

import ru.eltex.app.java.enums.Firm;
import ru.eltex.app.java.enums.OS;
import ru.eltex.app.java.enums.Title;

import java.io.Serializable;
import java.util.Scanner;
import java.util.UUID;

abstract public class Electronics implements ICrudAction, Serializable {
    public static int counter;//Счетчик товаров
    public UUID id; //Идентификатор товара
    private Title title;//Название
    private int price; //Цена
    private Firm firm; //Фирма
    private String mark; //Модель
    private OS os;//ОС
    static Scanner in=new Scanner(System.in);
    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }
    public UUID getId() {
        return id;
    }

}
