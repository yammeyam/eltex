package ru.eltex.app.java.products;
import ru.eltex.app.java.enums.Body;
import ru.eltex.app.java.enums.Firm;
import ru.eltex.app.java.enums.OS;
import ru.eltex.app.java.enums.Title;

import java.util.UUID;

public class Phone extends Electronics {

    private Body body;

    public Phone() {
        setTitle(Title.MOBILEPHONE);
        id= UUID.randomUUID();
    }
    public Phone(boolean a) {
        if (a) {
            setTitle(Title.MOBILEPHONE);
            id = UUID.randomUUID();
            create();

        }
    }


    public Phone(Body body, int price, Firm firm, String mark, OS os) {
        id= UUID.randomUUID();
        this.body = body;
        setFirm(firm);
        setMark(mark);
        setTitle(Title.MOBILEPHONE);
        setOs(os);
        setPrice(price);
    }


    @Override
    public void create() {
        counter++;
        body= Body.class.getEnumConstants()[(int)((Math.random())*Body.class.getEnumConstants().length)];
        setFirm(Firm.class.getEnumConstants()[(int)((Math.random())*Firm.class.getEnumConstants().length)]);
        setMark("M721H");
        setOs(OS.class.getEnumConstants()[(int)((Math.random())*OS.class.getEnumConstants().length)]);
        setPrice((int)(Math.random()*10000));
    }

    @Override
    public void read() {
        System.out.println("ID: "+id+"\nНазвание: "+getTitle()+"\nФирма: "+getFirm()+"\nМодель: "+getMark()+"\nОперационная система: "+getOs()+"\nТип корпуса:"+body+"\nЦена: "+getPrice()+" руб");
    }

    @Override
    public void update() {
        try {
            System.out.println("Введите фирму(APPLE, SAMSUNG, NOKIA)");
            setFirm(Firm.valueOf(in.nextLine()));
            System.out.println("Введите модель");
            setMark(in.nextLine());
            System.out.println("Введите операционную систему(ANDROID, IOS, NONE;)");
            setOs(OS.valueOf(in.nextLine()));
            System.out.println("Введите тип корпуса(CLASSIC, CLAMSHELL)");
            body=Body.valueOf(in.nextLine());
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
        body = null;
        setFirm(null);
        setMark(null);
        setTitle(null);
        setOs(null);
        setPrice(0);
    }
}
