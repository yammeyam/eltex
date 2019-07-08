package ru.eltex.app.java.products;

import ru.eltex.app.java.enums.Firm;
import ru.eltex.app.java.enums.GPU;
import ru.eltex.app.java.enums.OS;
import ru.eltex.app.java.enums.Title;

import java.util.UUID;

public class Tablet extends Electronics {
    private GPU gpu;
    private String resol;
    public Tablet(){
        setTitle(Title.TABLET);
        id= UUID.randomUUID();
    }
    public Tablet(boolean a) {
        if(a) {
            setTitle(Title.TABLET);
            id = UUID.randomUUID();
            create();
        }
    }

    public Tablet(GPU gpu, String resol, int price, Firm firm, String mark, OS os){
        id= UUID.randomUUID();
        this.gpu=gpu;
        this.resol=resol;
        setFirm(firm);
        setMark(mark);
        setTitle(Title.TABLET);
        setOs(os);
        setPrice(price);
    }
    @Override
    public void create() {
        counter++;
        gpu= GPU.class.getEnumConstants()[(int)((Math.random())*GPU.class.getEnumConstants().length)];
        resol="800x480";
        setFirm(Firm.class.getEnumConstants()[(int)((Math.random())*Firm.class.getEnumConstants().length)]);
        setMark("1");
        setOs(OS.class.getEnumConstants()[(int)((Math.random())*OS.class.getEnumConstants().length)]);
        setPrice((int)(Math.random()*50000));
    }

    @Override
    public void read() {
        System.out.println("ID: "+id+"\nНазвание: "+getTitle()+"\nФирма: "+getFirm()+"\nМодель: "+getMark()+"\nОперационная система: "+getOs()+"\nВидеопроцессор:"+gpu+"\nРазрешение: "+resol+"\nЦена: "+getPrice()+" руб");
    }

    @Override
    public void update() {
    try{
        System.out.println("Введите фирму(APPLE, SAMSUNG, NOKIA)");
        setFirm(Firm.valueOf(in.nextLine()));
        System.out.println("Введите модель");
        setMark(in.nextLine());
        System.out.println("Введите операционную систему(ANDROID, IOS, NONE;)");
        setOs(OS.valueOf(in.nextLine()));
        System.out.println("Введите видеопроцессор(MALI, ADRENO)");
        gpu=GPU.valueOf(in.nextLine());
        System.out.println("Введите разрешение");
        resol=String.valueOf(in.nextLine());
        System.out.println("Введите цену");
        setPrice(in.nextInt());
        System.out.println("Записано");
        in.nextLine();
    }catch (IllegalArgumentException e){
        System.out.println("Введены невозможные данные");
    }
    }

    @Override
    public void delete() {
        counter--;
        id= null;
        gpu = null;
        resol=null;
        setFirm(null);
        setMark(null);
        setTitle(null);
        setOs(null);
        setPrice(0);
    }
}
